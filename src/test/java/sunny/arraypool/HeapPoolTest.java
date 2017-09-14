package sunny.arraypool;

import sunny.arraypool.heap.HeapIntArrayPool;
import sunny.arraypool.core.HeapStats;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class HeapPoolTest {

    public static void main(String[] args) throws Exception
    {
        init();

        new HeapPoolTest().test1();
    }

    static HeapIntArrayPool pool;
    //@BeforeClass
    public static void init()
    {
        WeakDeamonRunner runner = new WeakDeamonRunner(10_000, 30_000, 3000);
        pool = new HeapIntArrayPool(32, 1024 * 1024, runner);

        runner.start();
    }

    //@Test
    public void test1() throws InterruptedException {
        for(int i=0;i<10;i++) {
            for(int j=5;j<10;j++)
            {
                int size = 2<<(j+1);
                int[] array = pool.get(size);
                System.out.println("heap used:"+HeapStats.getUsed());
                pool.recycle(array);
                System.out.println("heap used:"+HeapStats.getUsed());
            }
        }

        System.out.println("heap used:"+HeapStats.getUsed());

        Thread.sleep(15000);
        System.out.println("------");
        System.out.println("heap used:"+HeapStats.getUsed());
        /*
        for(int j=5;j<10;j++)
        {
            int size = 2<<(j+1);
            int[] array = pool.get(size);
            System.out.println("heap used:"+HeapStats.getUsed());

        }
        */

        Thread.sleep(20000);
        System.out.println("------");
        System.out.println("heap used:"+HeapStats.getUsed());

        System.exit(0);
    }
}
