package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraypool.core.HeapStats;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/12.
 */
public class HeapArrayLongTest {

    static ArrayFactory arrayFactory;

    @BeforeClass
    public static void beforeClass()
    {
        WeakDeamonRunner<Object> runner = new WeakDeamonRunner<>(10000, 300000, 1000);
        arrayFactory = ArrayFactory.builder().setBooleanPoolConfig(32, 1024, runner)
                .setIntPoolConfig(32, 1024, runner)
                .setLongPoolConfig(32, 1024, runner)
                .setCharPoolConfig(32, 1024, runner)
                .setShortPoolConfig(32, 1024, runner)
                .setStrPoolConfig(32, 1024, runner)
                .setDecimalPoolConfig(32, 1024, runner)
                .build();

    }


    public void testLongArrayN(int capacity)
    {
        LongArray array = arrayFactory.createLongArray(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert i == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    //@Test
    public void testLongArray16()
    {
        testLongArrayN(16);
    }

    @Test
    public void testLongArray32()
    {
        testLongArrayN(32);
    }

    @Test
    public void testLongArray512()
    {
        testLongArrayN(512);
    }

    @Test
    public void testLongArray1024()
    {
        testLongArrayN(1024);
    }

    //@Test
    public void testLongArray2048()
    {
        testLongArrayN(2048);
    }

    public void testLongArrayListN(int capacity)
    {
        LongArrayList array = arrayFactory.createLongArrayList(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert i == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    //@Test
    public void testLongArrayList16()
    {
        testLongArrayN(16);
    }

    @Test
    public void testLongArrayList32()
    {
        testLongArrayN(32);
    }

    @Test
    public void testLongArrayList512()
    {
        testLongArrayN(512);
    }

    @Test
    public void testLongArrayList1024()
    {
        testLongArrayN(1024);
    }

    //@Test
    public void testLongArrayList2048()
    {
        testLongArrayN(2048);
    }
}
