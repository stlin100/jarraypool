package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;

/**
 * Created by lzx on 17/9/6.
 */
public class AHeapShortArrayLevelPool extends AbstractArrayLevelPool<short[]> {


    public AHeapShortArrayLevelPool(int levelSize)
    {
        super(levelSize, Short.BYTES * levelSize);
    }

    public short[] create()
    {
        return new short[levelSize];
    }
}
