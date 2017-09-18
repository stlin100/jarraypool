package sunny.util;

/**
 * Created by lzx on 17/9/13.
 */
public class Util {

    public static int twoPowSizeFor(int value)
    {
        if(value==0)
            return 0;
        if(value==1)
            return 2;
        return jdk8(value);
    }

    private static int pow2Ceiling1(int value) {
        int leading0 = Integer.numberOfLeadingZeros(value);
        int bitCount = Integer.bitCount(value);
        if(bitCount==1)
            return 1 << (31 - leading0);
        else
            return 1 << (32 - leading0);
    }


    private static final int jdk8(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

}
