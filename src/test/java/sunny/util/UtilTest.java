package sunny.util;

import org.junit.Test;

/**
 * Created by lzx on 17/9/13.
 */
public class UtilTest {

    @Test
    public void testPow2Ceiling()
    {
        int v = 0;
        for(int i=1;i<=8;i++)
        {
            v = Util.pow2Ceiling(i);
        }
    }

    @Test
    public void test1()
    {
        int v = 1;
        for(int i=0;i<8;i++)
        {
            v = getHighestOnBit(i);
            v = Integer.lowestOneBit(i);
            v = Integer.numberOfLeadingZeros(i);
            v = Integer.bitCount(i);
        }
    }

    private int getHighestOnBit(int value)
    {
        return Integer.highestOneBit(value);
    }
}
