package sunny.arraypool.heap;

import sunny.arraypool.core.AbstractArrayLevelPool;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class HeapCharArrayPool extends HeapArrayPool<char[]> {

    public HeapCharArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<char[]> createLevelPool(int levelSize) {
        return new HeapCharArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(char[] array) {
        return array.length;
    }


}
