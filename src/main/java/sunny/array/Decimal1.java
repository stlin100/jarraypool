package sunny.array;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/8/31.
 */
public abstract class Decimal1 implements Comparable<Decimal1>{

    abstract long longValue();
    abstract int scale();  //one byte
    abstract int getScaleValue10X();
    abstract int getScaleValue();


    public abstract BigDecimal toBigDecimal();

    public int compareTo(Decimal1 o)
    {
        int c = (int)(longValue() - o.longValue());
        if(c!=0)
            return c;
        int scaleValue10x1 = getScaleValue10X();
        int scaleValue10x2 = o.getScaleValue10X();

        if(scaleValue10x1==scaleValue10x2)
            return getScaleValue() - o.getScaleValue();

        if(scaleValue10x1==0 && scaleValue10x2!=0)
            return -1;
        if(scaleValue10x1!=0 && scaleValue10x2==0)
            return 1;

        return (int) ((1.0d * getScaleValue() / Math.pow(10,scaleValue10x1)) -( 1.0d * o.getScaleValue() / Math.pow(10, scaleValue10x2)));

    }
}
