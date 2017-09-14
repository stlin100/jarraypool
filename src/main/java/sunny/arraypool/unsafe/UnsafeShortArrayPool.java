package sunny.arraypool.unsafe;

import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafeShortArrayPool extends UnsafeArrayPool {


    public UnsafeShortArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner) {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public UnsafeArrayLevelPool createLevelPool(int levelSize) {
        return new UnsafeShortArrayLevelPool(levelSize);
    }
}
