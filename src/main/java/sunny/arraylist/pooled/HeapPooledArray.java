package sunny.arraylist.pooled;

import sunny.arraypool.heap.HeapArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class HeapPooledArray<T> extends PooledArray<T>{
    public HeapPooledArray(HeapArrayPool<T> pool, int capacity) {
        super(pool, capacity);
    }
}
