package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class AHeapIntArrayPool extends AbstractArrayPool<int[]> {

    public AHeapIntArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<int[]> createLevelPool(int levelSize) {
        return new AHeapIntArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(int[] array) {
        return array.length;
    }


}
