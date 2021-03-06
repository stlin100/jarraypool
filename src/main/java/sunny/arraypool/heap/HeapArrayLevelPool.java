package sunny.arraypool.heap;

import sunny.arraypool.core.AbstractArrayLevelPool;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class HeapArrayLevelPool<TARRAY> extends AbstractArrayLevelPool<TARRAY> {

    public HeapArrayLevelPool(int levelSize, int heapBytes) {
        super(levelSize, heapBytes);
    }
}
