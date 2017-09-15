package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.LongArray;

/**
 * Created by lzx on 17/9/8.
 */
public class HeapPooledLongArray extends PooledArray<long[]> implements LongArray {

    private int size;

    public HeapPooledLongArray(ArrayPool<long[]> pool, int capacity) {
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
