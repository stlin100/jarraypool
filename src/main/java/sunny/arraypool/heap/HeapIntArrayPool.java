package sunny.arraypool.heap;

import sunny.arraypool.core.AbstractArrayLevelPool;
import sunny.arraypool.core.WeakDeamonRunner;

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
