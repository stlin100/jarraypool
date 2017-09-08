package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;

/**
 * Created by lzx on 17/9/6.
 */
public class HeapShortArrayLevelPool extends HeapArrayLevelPool<short[]> {


    public HeapShortArrayLevelPool(int levelSize)
    {
        super(levelSize, Short.BYTES * levelSize);
    }

    public short[] create()
    {
        return new short[levelSize];
    }
}
