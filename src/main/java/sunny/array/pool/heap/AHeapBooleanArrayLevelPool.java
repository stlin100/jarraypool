package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;

/**
 * Created by lzx on 17/9/6.
 */
public class AHeapBooleanArrayLevelPool extends AbstractArrayLevelPool<boolean[]> {


    public AHeapBooleanArrayLevelPool(int levelSize)
    {
        super(levelSize, Byte.BYTES * levelSize);
    }

    public boolean[] create()
    {
        return new boolean[levelSize];
    }
}
