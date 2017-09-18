package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeArrayPool;
import sunny.arraylist.IntArray;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledUnsafeIntArray extends PooledUnsafeArray implements IntArray{

    private int size;

    public PooledUnsafeIntArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, int value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        array.putInt(index * Integer.BYTES, value);
    }

    @Override
    public void append(int value) {
        ensureCapacity(size);
        array.putInt(size * Integer.BYTES, value);
        size++;
    }

    @Override
    public int get(int index) {
        return array.getInt(index * Integer.BYTES);
    }
}
