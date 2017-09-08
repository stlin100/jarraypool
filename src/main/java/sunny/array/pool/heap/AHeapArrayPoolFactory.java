package sunny.array.pool.heap;

import sunny.array.pool.ArrayPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class AHeapArrayPoolFactory {

    public static ArrayPool<int[]> createIntArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new AHeapIntArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    public static AbstractArrayPool<long[]> createLongArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new AHeapLongArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    public static AbstractArrayPool<char[]> createCharArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new AHeapCharArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    public static AbstractArrayPool<short[]> createShortArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new AHeapShortArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    public static AbstractArrayPool<boolean[]> createBooleanArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new AHeapBooleanArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

}
