package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraypool.core.HeapStats;
import sunny.arraypool.core.WeakDeamonRunner;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/9/12.
 */
public class HeapArrayDecimalTest {

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

    public void testDecimalArrayN(int capacity)
    {
        DecimalArray array = arrayFactory.createDecimalArray(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert new BigDecimal(i).equals(array.getBigDecimal(i));

        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    @Test
    public void testDecimalArray16()
    {
        testDecimalArrayN(16);
    }

    @Test
    public void testDecimalArray32()
    {
        testDecimalArrayN(32);
    }

    //@Test
    public void testDecimalArray512()
    {
        testDecimalArrayN(512);
    }

    //@Test
    public void testDecimalArray1024()
    {
        testDecimalArrayN(1024);
    }

    //@Test
    public void testDecimalArray2048()
    {
        testDecimalArrayN(2048);
    }

    public void testDecimalArrayListN(int capacity)
    {
        DecimalArrayList array = arrayFactory.createDecimalArrayList(capacity);
        for(int i=0;i<capacity;i++)
            array.set(i, i);
        for(int i=0;i<capacity;i++)
            assert new BigDecimal(i).equals(array.getBigDecimal(i));
        array.free();

        System.out.println("Used: " + HeapStats.getUsed());
    }

    @Test
    public void testDecimalArrayList16()
    {
        testDecimalArrayN(16);
    }

    @Test
    public void testDecimalArrayList32()
    {
        testDecimalArrayN(32);
    }

    //@Test
    public void testDecimalArrayList512()
    {
        testDecimalArrayN(512);
    }

    //@Test
    public void testDecimalArrayList1024()
    {
        testDecimalArrayN(1024);
    }

    //@Test
    public void testDecimalArrayList2048()
    {
        testDecimalArrayN(2048);
    }
}
