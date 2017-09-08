package sunny.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by lzx on 17/8/30.
 */
public class LongArrayTest {
    @Before
    public void before()
    {
        LongArray array = new PrimitiveLongArray(1024);
        array.free();
        array = new UnsafeLongArray(1024);
        array.free();
    }

    private int putCount = 1024 * 100;

    @Test
    public void test0()
    {
        long[] array = new long[putCount];
        for(int i=0;i<putCount;i++)
        {
            assert i < putCount;
            array[i] = i;
        }
        for(int i=0;i<putCount;i++)
        {
            assert i < putCount;
            long v = array[i];
            if(i != v)
                throw new RuntimeException();
        }
    }

    @Test
    public void testPrimitive0()
    {
        LongArray array = new PrimitiveLongArray(1024);
        testPut(array, putCount);
        testGet(array, putCount);
    }

    @Test
    public void testPrimitive1()
    {
        LongArray array = new PrimitiveLongArray(1024);
        testPut(array, putCount);
        testGet(array, putCount);
    }

    @Test
    public void testUnsafe()
    {
        LongArray array = new UnsafeLongArray(1024);
        testPut(array, putCount);
        testGet(array, putCount);
    }

    public void testPut(LongArray array, int size)
    {
        for(int i=0;i<size;i++)
            array.set(i, 0L + Integer.MAX_VALUE + i);
    }

    public void testGet(LongArray array, int size)
    {
        for(int i=0;i<size;i++)
            Assert.assertEquals(0L + Integer.MAX_VALUE + i , array.get(i));
    }
}