package sunny.array.pool.unsafe;

import sunny.array.pool.a.AbstractArrayLevelPool;
import sunny.array.pool.a.WeakDeamonRunner;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafeIntArrayPool extends UnsafeArrayPool {


    public UnsafeIntArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner) {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public UnsafeArrayLevelPool createLevelPool(int levelSize) {
        return new UnsafeIntArrayLevelPool(levelSize);
    }
}
