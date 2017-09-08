package sunny.array;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/8/31.
 */
public class Decimal2 implements Comparable<Decimal2> {

    private static final BigDecimal longMax = new BigDecimal(Long.MAX_VALUE);
    private static final BigDecimal longMin = new BigDecimal(Long.MIN_VALUE);

    private byte scale;
    private long longValue;
    private int scaleValue;
    private byte scaleValue10x;

    public Decimal2(int l)
    {
        longValue = l;
    }

    public Decimal2(long l)
    {
        longValue = l;
    }

    public Decimal2(double value)
    {
        this("" + value);
    }

    public Decimal2(BigDecimal big)
    {
        this(big.toString());
    }

    public Decimal2(String value)
    {
        String[] parts = value.split("\\.");
        longValue = Long.parseLong(parts[0]);
        if(parts.length>0)
        {
            scale = (byte)parts[1].length();
            byte rightZeroCount = 0;
            for(int i=parts[1].length()-1;i>=0;i--)
                rightZeroCount ++;
            scaleValue10x = (byte)(scale - rightZeroCount);
            if(scaleValue10x>0)
                scaleValue = Integer.parseInt(parts[1]);
        }
    }

    public Decimal2(long longValue, byte scale, int scaleValue, byte scaleValue10x)
    {
        this.longValue = longValue;
        this.scale = scale;
        this.scaleValue = scaleValue;
        this.scaleValue10x = scaleValue10x;
    }

    //TODO:
    @Override
    public int compareTo(Decimal2 o) {
        int c = (int)(longValue - o.longValue);
        if(c!=0)
            return c;

        if(scaleValue10x==o.scaleValue10x)
            return scaleValue - o.scaleValue;

        if(scaleValue10x==0 && o.scaleValue10x!=0)
            return -1;
        if(scaleValue10x!=0 && o.scaleValue10x==0)
            return 1;

        return (int) ((1.0d * scaleValue / Math.pow(10,scaleValue10x)) -( 1.0d * o.scaleValue / Math.pow(10, o.scaleValue10x)));
    }
}
