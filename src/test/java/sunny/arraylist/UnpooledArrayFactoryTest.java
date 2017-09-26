package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraylist.metric.Metrics;
import sunny.arraylist.unpooled.UnpooledHeapArrayFactory;
import sunny.arraylist.unpooled.UnpooledUnsafeArrayFactory;

/**
 * Created by lzx on 17/9/22.
 */
public class UnpooledArrayFactoryTest {

    private static UnpooledUnsafeArrayFactory unsafeFactory;
    private static UnpooledHeapArrayFactory heapFactory;

    @BeforeClass
    public static void beforeClass()
    {
        unsafeFactory = new UnpooledUnsafeArrayFactory();
        heapFactory = new UnpooledHeapArrayFactory();

        //factory = new UnpooledL2ArrayFactory(20 * 1024 * 1024, 1024);
    }

    @Test
    public void testStringHeap()
    {
        testString(heapFactory);
    }

    @Test
    public void testStringUnsafe()
    {
        testString(unsafeFactory);
    }

    @Test
    public void testLongHeap()
    {
        testLong(heapFactory);
    }

    @Test
    public void testLongUnsafe()
    {
        testLong(unsafeFactory);
    }

    @Test
    public void testDecimalHeap()
    {
        testDecimal(heapFactory);
    }

    @Test
    public void testDecimalUnsafe()
    {
        testDecimal(unsafeFactory);
    }

    public void testString(ArrayFactory factory)
    {
        java.util.ArrayList<Array> all = new java.util.ArrayList<>();
        for(int i=0;i<1000;i++)
        {
            for(int j=1;j<7;j++)
            {
                int capacity = 1<<j;
                StrArray array = factory.createStrArray(capacity);
                for(int k=0;k<capacity;k++)
                    array.append("fddfdfdfffdd");
                all.add(array);
            }
        }

        long heapSize = Metrics.unpooledAllocHeapSize.getCount();
        long unsafeSize = Metrics.unpooledAllocUnsafeSize.getCount();

        System.out.println("heapSize:" + heapSize);
        System.out.println("unsafeSize:" + unsafeSize);

        for(Array a: all)
            a.free();

        heapSize = Metrics.unpooledAllocHeapSize.getCount();
        unsafeSize = Metrics.unpooledAllocUnsafeSize.getCount();

        System.out.println("heapSize:" + heapSize);
        System.out.println("unsafeSize:" + unsafeSize);

    }

    public void testLong(ArrayFactory factory)
    {
        java.util.ArrayList<Array> all = new java.util.ArrayList<>();
        for(int i=0;i<1000;i++)
        {
            for(int j=5;j<10;j++)
            {
                int capacity = 1<<j;
                LongArray array = factory.createLongArrayList(capacity);
                for(int k=0;k<capacity;k++)
                    array.append(k);
                all.add(array);
            }
        }

        long heapSize = Metrics.unpooledAllocHeapSize.getCount();
        long unsafeSize = Metrics.unpooledAllocUnsafeSize.getCount();

        System.out.println("heapSize:" + heapSize);
        System.out.println("unsafeSize:" + unsafeSize);

        for(Array a: all)
            a.free();

        heapSize = Metrics.unpooledAllocHeapSize.getCount();
        unsafeSize = Metrics.unpooledAllocUnsafeSize.getCount();

        System.out.println("heapSize:" + heapSize);
        System.out.println("unsafeSize:" + unsafeSize);

    }

    public void testDecimal(ArrayFactory factory)
    {
        java.util.ArrayList<Array> all = new java.util.ArrayList<>();
        for(int i=0;i<1000;i++)
        {
            for(int j=5;j<10;j++)
            {
                int capacity = 1<<j;
                DecimalArray array = factory.createDecimalArrayList(capacity);
                for(int k=0;k<capacity;k++)
                    array.append(k);
                all.add(array);
            }
        }

        long heapSize = Metrics.unpooledAllocHeapSize.getCount();
        long unsafeSize = Metrics.unpooledAllocUnsafeSize.getCount();

        System.out.println("heapSize:" + heapSize);
        System.out.println("unsafeSize:" + unsafeSize);

        for(Array a: all)
            a.free();

        heapSize = Metrics.unpooledAllocHeapSize.getCount();
        unsafeSize = Metrics.unpooledAllocUnsafeSize.getCount();

        System.out.println("heapSize:" + heapSize);
        System.out.println("unsafeSize:" + unsafeSize);

    }
}
