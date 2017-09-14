package sunny.arraypool.core;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lzx on 17/9/7.
 */
public class HeapStats {
    private static AtomicLong poolUsed = new AtomicLong(0);

    public static void incUsed(int bytes)
    {
        poolUsed.addAndGet(bytes);
    }

    public static void decUsed(int bytes)
    {
        poolUsed.addAndGet(-bytes);
    }

    public static long getUsed()
    {
        return poolUsed.get();
    }

    public static boolean checkLess(long max)
    {
        return poolUsed.get() < max;
    }
}
