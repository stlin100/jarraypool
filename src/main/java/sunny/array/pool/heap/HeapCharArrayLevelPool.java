package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;

/**
 * Created by lzx on 17/9/6.
 */
public class HeapCharArrayLevelPool extends HeapArrayLevelPool<char[]> {


    public HeapCharArrayLevelPool(int levelSize)
    {
        super(levelSize, Short.BYTES * levelSize);
    }

    public char[] create()
    {
        return new char[levelSize];
    }
}
