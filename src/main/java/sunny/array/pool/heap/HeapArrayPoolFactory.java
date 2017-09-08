package sunny.array.pool.heap;

import sunny.array.pool.ArrayPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class HeapArrayPoolFactory implements sunny.array.pool.ArrayPoolFactory {

    @Override
    public HeapIntArrayPool createIntArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new HeapIntArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public HeapLongArrayPool createLongArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new HeapLongArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public HeapCharArrayPool createCharArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new HeapCharArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public HeapShortArrayPool createShortArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new HeapShortArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public HeapBooleanArrayPool createBooleanArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new HeapBooleanArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

}
