package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class AHeapLongArrayPool extends AbstractArrayPool<long[]> {

    public AHeapLongArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<long[]> createLevelPool(int levelSize) {
        return new AHeapLongArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(long[] array) {
        return array.length;
    }


}
