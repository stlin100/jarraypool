package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraypool.core.HeapStats;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/12.
 */
public class HeapArrayStrTest {

    static ArrayFactory arrayFactory;

    @BeforeClass
    public static void beforeClass()
    {
        WeakDeamonRunner<Object> runner = new WeakDeamonRunner<>(10000, 300000, 1000);
        arrayFactory = ArrayFactory.builder().setBooleanPoolConfig(2, 1024, runner)
                .setIntPoolConfig(2, 1024, runner)
                .setLongPoolConfig(2, 1024, runner)
                .setCharPoolConfig(2, 1024, runner)
                .setShortPoolConfig(2, 1024, runner)
                .setStrPoolConfig(2, 1024, runner)
                .setDecimalPoolConfig(2, 1024, runner)
                .build();

    }


    private String makeString(int n)
    {
        StringBuilder builder = new StringBuilder("n");
        for(int i=1;i<n;i++)
            builder.append("n");

        return builder.toString();
    }

    public void testStrArrayN(int capacity)
    {
        StrArray array = arrayFactory.createStrArray(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, makeString(i));
        for(int i=0;i<capacity;i++)
            assert makeString(i).equals(array.getString(i));

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    @Test
    public void testStrArray16()
    {
        testStrArrayN(16);
    }

    @Test
    public void testStrArray32()
    {
        testStrArrayN(32);
    }

    @Test
    public void testStrArray512()
    {
        testStrArrayN(512);
    }

    @Test
    public void testStrArray1024()
    {
        testStrArrayN(1024);
    }

    @Test
    public void testStrArray2048()
    {
        testStrArrayN(2048);
    }

    public void testStrArrayListN(int capacity)
    {
        StrArrayList array = arrayFactory.createStrArrayList(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, makeString(i));
        for(int i=0;i<capacity;i++)
            assert makeString(i).equals(array.getString(i));
        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    @Test
    public void testStrArrayList16()
    {
        testStrArrayN(16);
    }

    @Test
    public void testStrArrayList32()
    {
        testStrArrayN(32);
    }

    @Test
    public void testStrArrayList512()
    {
        testStrArrayN(512);
    }

    @Test
    public void testStrArrayList1024()
    {
        testStrArrayN(1024);
    }

    @Test
    public void testStrArrayList2048()
    {
        testStrArrayN(2048);
    }
}
