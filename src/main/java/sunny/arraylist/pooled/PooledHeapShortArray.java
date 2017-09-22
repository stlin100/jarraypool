package sunny.arraylist.pooled;

import sunny.arraylist.ShortArray;
import sunny.arraypool.ArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapShortArray extends PooledArray<short[]> implements ShortArray {

    private int size;

    public PooledHeapShortArray(ArrayPool<short[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(short value) {
        ensureCapacity(size);
        array[size] = value;
        size++;
    }

    @Override
    public void set(int index, short value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        array[index] = value;
    }

    @Override
    public short get(int index) {
        return array[index];
    }
}
