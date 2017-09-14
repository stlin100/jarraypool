package sunny.arraypool.unsafe;

import sunny.arraypool.core.WeakDeamonRunner;

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
