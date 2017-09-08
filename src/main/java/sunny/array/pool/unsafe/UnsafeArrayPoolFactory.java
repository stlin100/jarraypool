package sunny.array.pool.unsafe;

import sunny.array.pool.ArrayPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;
import sunny.array.pool.heap.*;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/7.
 */
public class UnsafeArrayPoolFactory implements sunny.array.pool.ArrayPoolFactory {

    @Override
    public ArrayPool<UnsafeMemory> createIntArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new UnsafeIntArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public ArrayPool<UnsafeMemory> createLongArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new UnsafeLongArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public ArrayPool<UnsafeMemory> createCharArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new UnsafeCharArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public ArrayPool<UnsafeMemory> createShortArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new UnsafeShortArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public ArrayPool<UnsafeMemory> createBooleanArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        return new UnsafeBooleanArrayPool(minLevelSize, maxLevelSize, deamonRunner);
    }

}
