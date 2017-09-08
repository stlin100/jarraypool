package sunny.array;

import sunny.memory.UnsafeOffHeapMemory;

import java.math.BigDecimal;

/** 
 * 
 * format:
 *      1. with scale: total 17bytes, long(longValue) | byte(scale) |  long(scaleValue)
 *      2. without scale: total 9bytes, long(longValue) | byte(scale)
 * Created by lzx on 17/8/31.
 */
public class Decimal implements Comparable<Decimal>{

    private final int CHAR_BYTES = 2;

    UnsafeOffHeapMemory memory;
    private int offset;
    private boolean reference;

    public Decimal(int value)
    {
        this((long)value);
    }

    public Decimal(long value)
    {
        init(value);
    }


    public Decimal(BigDecimal big)
    {
        this(big.toString());
    }

    public Decimal(String value)
    {
        init(value);
    }

    private void init(String value) {


        String[] parts = value.split("\\.");

        long longValue = 0;
        if(parts[0].length()>0)
            longValue = Long.parseLong(parts[0]);

        if(parts.length>1 && parts[1].length()>0)
        {
            String right = parts[1];
            int scale = right.length();
            if(scale>18)
            {
                scale = 18;
                right = right.substring(0, 18);
            }

            if(scale>0) {
                long scaleValue = Long.parseLong(right);
                if (scaleValue > 0) {
                    memory = new UnsafeOffHeapMemory(17);
                    memory.putLong(0, longValue);
                    memory.putByte(8, (byte) scale);

                    memory.putLong(8 + 1, scaleValue);
                    return;
                } else {
                    scale = -scale;
                }
            }

            memory = new UnsafeOffHeapMemory(9);
            memory.putLong(0, longValue);
            memory.putByte(8, (byte)scale);

        }
        else
        {
            init(longValue);
        }
    }

    private void init(long longValue) {
        memory = new UnsafeOffHeapMemory(10);
        memory.putLong(0, longValue);
        memory.putByte(8, (byte)0);
        memory.putByte(8 + 1, (byte)0);
    }

    public Decimal(UnsafeOffHeapMemory memory, int offset)
    {
        this.memory = memory;
        this.offset = offset;
        this.reference = true;

        //scaleOffset = offset + 8;
        //scaleValue10XOffset = scaleOffset + 1;
        //scaleValueOffset = scaleValue10XOffset + 1;
    }

    long longValue() {
        return memory.getLong(offset);
    }

    int scale() {
        return memory.getByte(offset + 8);
    }


    long getScaleValue() {
        if(scale() == 0 )
            return 0;
        return memory.getLong(offset + 8 + 1);
    }


    public BigDecimal toBigDecimal() {
        int scale = scale();
        if(scale==0)
            return new BigDecimal(longValue());
        else if(scale<0)
        {
            BigDecimal bd = new BigDecimal(longValue());
            bd.setScale(-scale);
            return bd;
        }

        long scaleValue = getScaleValue();

        String svalue = String.valueOf(scaleValue);
        StringBuilder sb = new StringBuilder();
        sb.append(longValue()).append('.');
        for(int i=0;i<(scale-svalue.length());i++)
            sb.append('0');
        sb.append(svalue);
        BigDecimal bd = new BigDecimal(sb.toString());
        return bd;
    }

    public String toString()
    {
        int scale = scale();
        if(scale<=0)
            return String.valueOf(longValue());


        long scaleValue = getScaleValue();
        String svalue = String.valueOf(scaleValue);
        StringBuilder sb = new StringBuilder();
        sb.append(longValue()).append('.');
        for(int i=0;i<(scale-svalue.length());i++)
            sb.append('0');
        sb.append(svalue);


        return sb.toString();
    }

    public int compareTo(Decimal o)
    {
        int c = (int)(longValue() - o.longValue());
        if(c!=0)
            return c;
        int scale1 = scale();
        int scale2 = o.scale();

        if(scale1==scale2)
            return (int)(getScaleValue() - o.getScaleValue());

        long v1 = getScaleValue();
        long v2 =o.getScaleValue();
        if(v1==0 && v2==0)
            return 0;
        if(v1==0 && v2!=0)
            return -1;
        if(v1!=0 && v2==0)
            return 1;


        double d1 = (1.0d * v1) / Math.pow(10,scale1);
        double d2 = (1.0d * v2) / Math.pow(10,scale2);
        return d1 == d2?0:(d1>d2?1:-1);

    }

    public void free()
    {
        if(!reference)
            memory.free();
    }
}
