package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/7.
 */
public class AHeapCharArrayPool extends AbstractArrayPool<char[]> {

    public AHeapCharArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public AbstractArrayLevelPool<char[]> createLevelPool(int levelSize) {
        return new AHeapCharArrayLevelPool(levelSize);
    }

    @Override
    public int arrayLength(char[] array) {
        return array.length;
    }


}
