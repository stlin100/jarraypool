package sunny.arraylist.pooled;

import sunny.array.pool.ArrayPool;
import sunny.arraylist.IntArray;
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
    public void set(int index, long value) {
        if(size<index+1)
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
