package sunny.arraylist.pooled;

import sunny.arraylist.LongArray;
import sunny.arraypool.ArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapLongArray extends PooledArray<long[]> implements LongArray {

    private int size;

    public PooledHeapLongArray(ArrayPool<long[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(long value) {
        ensureCapacity(size);
        array[size] = value;
        size++;
    }
    @Override
    public void set(int index, long value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        array[index] = value;
    }

    @Override
    public long get(int index) {
        return array[index];
    }
}
