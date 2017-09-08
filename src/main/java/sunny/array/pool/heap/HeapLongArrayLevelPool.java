package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;

/**
 * Created by lzx on 17/9/6.
 */
public class HeapLongArrayLevelPool extends HeapArrayLevelPool<long[]> {


    public HeapLongArrayLevelPool(int levelSize)
    {
        super(levelSize, Long.BYTES * levelSize);
    }

    public long[] create()
    {
        return new long[levelSize];
    }
}
