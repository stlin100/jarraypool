package sunny.array.pool.unsafe;

import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafeLongArrayPool extends UnsafeArrayPool {


    public UnsafeLongArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner) {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public UnsafeArrayLevelPool createLevelPool(int levelSize) {
        return new UnsafeLongArrayLevelPool(levelSize);
    }
}
