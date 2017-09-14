package sunny.arraypool.heap;

import sunny.arraypool.core.AbstractArrayLevelPool;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class HeapBooleanArrayPool extends HeapArrayPool<boolean[]> {

    public HeapBooleanArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<boolean[]> createLevelPool(int levelSize) {
        return new HeapBooleanArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(boolean[] array) {
        return array.length;
    }


}
