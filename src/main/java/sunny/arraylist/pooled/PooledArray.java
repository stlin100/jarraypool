package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.Array;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class PooledArray<T> implements Array {

    protected ArrayPool<T> pool;
    protected int capacity;
    protected T array;



    public PooledArray(ArrayPool<T> pool, int capacity)
    {
        this.pool = pool;
        this.capacity = capacity;
        array = pool.get(capacity);
    }

    protected PooledArray(ArrayPool<T> pool, int capacity, int requireCapacity)
    {
        this.pool = pool;
        this.capacity = capacity;
        array = pool.get(requireCapacity);
    }

    @Override
    public void free() {
        pool.recycle(array);
    }

    public void ensureCapacity(int index) {

    }
}
