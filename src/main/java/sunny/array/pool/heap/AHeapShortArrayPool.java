package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class AHeapShortArrayPool extends AbstractArrayPool<short[]> {

    public AHeapShortArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<short[]> createLevelPool(int levelSize) {
        return new AHeapShortArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(short[] array) {
        return array.length;
    }


}
