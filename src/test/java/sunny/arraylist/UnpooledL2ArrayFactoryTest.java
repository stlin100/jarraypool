package sunny.arraylist;

import org.junit.BeforeClass;
import org.junit.Test;
import sunny.arraylist.factory.UnpooledL2ArrayFactory;
import sunny.arraylist.metric.Metrics;

/**
 * Created by lzx on 17/9/22.
 */
public class UnpooledL2ArrayFactoryTest {

    private static UnpooledL2ArrayFactory factory;

    @BeforeClass
    public static void beforeClass()
    {
        factory = new UnpooledL2ArrayFactory(20 * 1024 * 1024, 1024);
    }

    @Test
    public void test()
    {
        java.util.ArrayList<Array> all = new java.util.ArrayList<>();
        for(int i=0;i<1000;i++)
        {
            for(int j=1;j<10;j++)
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
}
