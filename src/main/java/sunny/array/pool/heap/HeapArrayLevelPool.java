package sunny.array.pool.heap;

import sunny.array.pool.a.AbstractArrayLevelPool;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class HeapArrayLevelPool<TARRAY> extends AbstractArrayLevelPool<TARRAY> {

    public HeapArrayLevelPool(int levelSize, int heapBytes) {
        super(levelSize, heapBytes);
    }
}
