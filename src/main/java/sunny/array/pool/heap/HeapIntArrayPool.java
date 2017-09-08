package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;
import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class HeapIntArrayPool extends HeapArrayPool<int[]> {

    public HeapIntArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<int[]> createLevelPool(int levelSize) {
        return new HeapIntArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(int[] array) {
        return array.length;
    }


}
