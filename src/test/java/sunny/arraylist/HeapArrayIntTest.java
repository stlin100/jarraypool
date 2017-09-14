package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraypool.core.HeapStats;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/12.
 */
public class HeapArrayIntTest {

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


    public void testIntArrayN(int capacity)
    {
        IntArray array = arrayFactory.createIntArray(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert i == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    //@Test
    public void testIntArray16()
    {
        testIntArrayN(16);
    }

    @Test
    public void testIntArray32()
    {
        testIntArrayN(32);
    }

    @Test
    public void testIntArray512()
    {
        testIntArrayN(512);
    }

    @Test
    public void testIntArray1024()
    {
        testIntArrayN(1024);
    }

    //@Test
    public void testIntArray2048()
    {
        testIntArrayN(2048);
    }

    public void testIntArrayListN(int capacity)
    {
        IntArrayList array = arrayFactory.createIntArrayList(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert i == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    //@Test
    public void testIntArrayList16()
    {
        testIntArrayN(16);
    }

    @Test
    public void testIntArrayList32()
    {
        testIntArrayN(32);
    }

    @Test
    public void testIntArrayList512()
    {
        testIntArrayN(512);
    }

    @Test
    public void testIntArrayList1024()
    {
        testIntArrayN(1024);
    }

    //@Test
    public void testIntArrayList2048()
    {
        testIntArrayN(2048);
    }
}
