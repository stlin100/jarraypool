package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class AHeapBooleanArrayPool extends AbstractArrayPool<boolean[]> {

    public AHeapBooleanArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<boolean[]> createLevelPool(int levelSize) {
        return new AHeapBooleanArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(boolean[] array) {
        return array.length;
    }


}
