package sunny.lang;

import sunny.arraylist.LongArray;

import java.math.BigDecimal;

/** 
 * 
 * format:
 *      with scale: total 16bytes, long(longValue) | [byte(scale) |  7bytes(scaleValue)]
 *      support scaleValue<10^16<2^56

 * Created by lzx on 17/8/31.
 */
public class Decimal implements Comparable<Decimal>{

    private final static long NULL_SCALEVALUE = Long.MIN_VALUE;
    private final static long NEGZEROVALUE = Long.MIN_VALUE;
    private LongArray array;
    private int offset;

    public Decimal(LongArray array, int offset)
    {
        this.array = array;
        this.offset = offset;
    }

    public void setOffset(int offset)
    {

        this.offset = offset;
    }

    public void setValue(int value)
    {
        setValue((long)value);
    }

    public void setValue(long value)
    {
        setLong(value);
    }

    public void setValue(BigDecimal big)
    {
        if(big==null)
            setNull();
        else
            setValue(big.toPlainString());
    }


    public void setValue(String value) {

        String[] parts = value.split("\\.");

        long longValue = 0;
        if(parts[0].length()>0)
        {
            if(parts[0].equals("-0"))
                longValue = Long.MIN_VALUE;
            else
                longValue = Long.parseLong(parts[0]);
        }

        if(parts.length>1 && parts[1].length()>0)
        {
            String right = parts[1];
            int scale = right.length();
            if(scale>16)
            {
                scale = 16;
                right = right.substring(0, 16);
            }

            long scaleValue = 0;

            if(scale>0) {
                scaleValue = Long.parseLong(right);
            }

            putMemory(longValue, (byte)scale, scaleValue);

        }
        else
        {
            setLong(longValue);
        }
    }


    private void putMemory(long longValue, byte scale, long scaleValue)
    {
        array.set(offset, longValue);
        array.set(offset + 1, makeScaleLong(scale, scaleValue));
    }

    private void setLong(long longValue) {
        putMemory(longValue, (byte)0, 0);
    }

    private void setNull()
    {
        array.set(offset, 0);
        array.set(offset + 1, NULL_SCALEVALUE);
    }

    private static final long makeScaleLong(long scale, long scaleValue)
    {
        if(scale==0)
            return 0;

        return (scale<<56) | scaleValue;
    }

    private static final  byte getScale(long scaleLong)
    {
        return (byte)(scaleLong >> 56);
    }

    private static final long getScaleValue(long scaleLong) {
        return scaleLong << 8 >> 8;
    }


    private long longValue() {
        return array.get(offset);
    }

    private long scaleLong() {
        return array.get(offset + 1);
    }


    public BigDecimal toBigDecimal() {
        long scaleLong = scaleLong();
        if(scaleLong==NULL_SCALEVALUE)
            return null;

        int scale = getScale(scaleLong);

        if(scale==0)
            return new BigDecimal(longValue());


        long scaleValue = getScaleValue(scaleLong);

        String svalue = String.valueOf(scaleValue);
        StringBuilder sb = new StringBuilder();
        long longValue = longValue();
        if(longValue==Long.MIN_VALUE)
            sb.append("-0");
        else
            sb.append(longValue);
        sb.append('.');
        for(int i=0;i<(scale-svalue.length());i++)
            sb.append('0');
        sb.append(svalue);
        BigDecimal bd = new BigDecimal(sb.toString());
        return bd;
    }

    public String toString()
    {
        long scaleLong = scaleLong();
        if(NULL_SCALEVALUE==scaleLong)
            return "";

        int scale = getScale(scaleLong);
        if(scale<=0)
            return String.valueOf(longValue());

        long scaleValue = getScaleValue(scaleLong);
        String svalue = String.valueOf(scaleValue);
        StringBuilder sb = new StringBuilder();
        long longValue = longValue();
        if(longValue==Long.MIN_VALUE)
            sb.append("-0");
        else
            sb.append(longValue);
        sb.append('.');
        for(int i=0;i<(scale-svalue.length());i++)
            sb.append('0');
        sb.append(svalue);

        return sb.toString();
    }

    public int compareTo(Decimal o)
    {
        long scaleLong = scaleLong();
        long scaleLong2 = o.scaleLong();

        if(scaleLong==NULL_SCALEVALUE && scaleLong2==NULL_SCALEVALUE)
            return 0;

        long longValue2 = o.longValue();

        if(scaleLong==NULL_SCALEVALUE)
        {
            return longValue2==Long.MIN_VALUE?1:-1;
        }
        long longValue = longValue();
        if(scaleLong2==NULL_SCALEVALUE)
        {
            return longValue==Long.MIN_VALUE?-1:1;
        }


        long c = (longValue==Long.MIN_VALUE?0:longValue) - (longValue2==Long.MIN_VALUE?0:longValue2);
        if(c!=0)
            return c>0?1:-1;

        int scale1 = getScale(scaleLong);
        int scale2 = getScale(scaleLong2);

        if(scale1==scale2)
        {
            c = (getScaleValue(scaleLong) - getScaleValue(scaleLong2));
            return c>0?1:-1;
        }

        long v1 = getScaleValue(scaleLong);
        long v2 =getScaleValue(scaleLong2);
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
        array.free();
    }
}
