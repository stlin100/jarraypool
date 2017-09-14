package sunny.util;

/**
 * Created by lzx on 17/9/13.
 */
public class Util {

    public static int pow2Ceiling(int value)
    {
        if(value==0)
            return 0;
        if(value==1)
            return 2;
        return pow2Ceiling1(value);
    }

    private static int pow2Ceiling1(int value) {
        int leading0 = Integer.numberOfLeadingZeros(value);
        int bitCount = Integer.bitCount(value);
        if(bitCount==1)
            return 1 << (31 - leading0);
        else
            return 1 << (32 - leading0);
    }
}
