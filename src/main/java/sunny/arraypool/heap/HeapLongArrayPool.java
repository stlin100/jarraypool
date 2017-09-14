package sunny.arraypool.heap;

import sunny.arraypool.core.AbstractArrayLevelPool;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class HeapLongArrayPool extends HeapArrayPool<long[]> {

    public HeapLongArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<long[]> createLevelPool(int levelSize) {
        return new HeapLongArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(long[] array) {
        return array.length;
    }


}
