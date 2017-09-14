package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraypool.core.HeapStats;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/12.
 */
public class HeapArrayCharTest {

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


    public void testCharArrayN(int capacity)
    {
        CharArray array = arrayFactory.createCharArray(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert i == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    //@Test
    public void testCharArray16()
    {
        testCharArrayN(16);
    }

    @Test
    public void testCharArray32()
    {
        testCharArrayN(32);
    }

    @Test
    public void testCharArray512()
    {
        testCharArrayN(512);
    }

    @Test
    public void testCharArray1024()
    {
        testCharArrayN(1024);
    }

    //@Test
    public void testCharArray2048()
    {
        testCharArrayN(2048);
    }

    public void testCharArrayListN(int capacity)
    {
        CharArrayList array = arrayFactory.createCharArrayList(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert i == array.get(i);

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    //@Test
    public void testCharArrayList16()
    {
        testCharArrayN(16);
    }

    @Test
    public void testCharArrayList32()
    {
        testCharArrayN(32);
    }

    @Test
    public void testCharArrayList512()
    {
        testCharArrayN(512);
    }

    @Test
    public void testCharArrayList1024()
    {
        testCharArrayN(1024);
    }

    //@Test
    public void testCharArrayList2048()
    {
        testCharArrayN(2048);
    }
}
