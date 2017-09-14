package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraypool.core.HeapStats;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/12.
 */
public class HeapArrayShortTest {

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


    public void testShortArrayN(int capacity)
    {
        ShortArray array = arrayFactory.createShortArray(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert i == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    @Test
    public void testShortArray16()
    {
        testShortArrayN(16);
    }

    @Test
    public void testShortArray32()
    {
        testShortArrayN(32);
    }

    @Test
    public void testShortArray512()
    {
        testShortArrayN(512);
    }

    @Test
    public void testShortArray1024()
    {
        testShortArrayN(1024);
    }

    @Test
    public void testShortArray2048()
    {
        testShortArrayN(2048);
    }

    public void testShortArrayListN(int capacity)
    {
        ShortArrayList array = arrayFactory.createShortArrayList(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert i == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    @Test
    public void testShortArrayList16()
    {
        testShortArrayN(16);
    }

    @Test
    public void testShortArrayList32()
    {
        testShortArrayN(32);
    }

    @Test
    public void testShortArrayList512()
    {
        testShortArrayN(512);
    }

    @Test
    public void testShortArrayList1024()
    {
        testShortArrayN(1024);
    }

    @Test
    public void testShortArrayList2048()
    {
        testShortArrayN(2048);
    }
}
