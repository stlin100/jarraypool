package sunny.arraylist.pooled;

import sunny.arraypool.heap.HeapArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class PooledHeapArray<T> extends PooledArray<T>{
    public PooledHeapArray(HeapArrayPool<T> pool, int capacity) {
        super(pool, capacity);
    }
}
