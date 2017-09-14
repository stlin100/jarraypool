package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraypool.core.HeapStats;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/12.
 */
public class HeapArrayBooleanTest {

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


    public void testBooleanArrayN(int capacity)
    {
        BooleanArray array = arrayFactory.createBooleanArray(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i%2==1);
        for(int i=0;i<capacity;i++)
            assert (i%2==1) == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    //@Test
    public void testBooleanArray16()
    {
        testBooleanArrayN(16);
    }

    @Test
    public void testBooleanArray32()
    {
        testBooleanArrayN(32);
    }

    @Test
    public void testBooleanArray512()
    {
        testBooleanArrayN(512);
    }

    @Test
    public void testBooleanArray1024()
    {
        testBooleanArrayN(1024);
    }

    //@Test
    public void testBooleanArray2048()
    {
        testBooleanArrayN(2048);
    }

    public void testBooleanArrayListN(int capacity)
    {
        BooleanArrayList array = arrayFactory.createBooleanArrayList(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i%2==1);
        for(int i=0;i<capacity;i++)
            assert (i%2==1) == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    //@Test
    public void testBooleanArrayList16()
    {
        testBooleanArrayN(16);
    }

    @Test
    public void testBooleanArrayList32()
    {
        testBooleanArrayN(32);
    }

    @Test
    public void testBooleanArrayList512()
    {
        testBooleanArrayN(512);
    }

    @Test
    public void testBooleanArrayList1024()
    {
        testBooleanArrayN(1024);
    }

    //@Test
    public void testBooleanArrayList2048()
    {
        testBooleanArrayN(2048);
    }
}
