package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeArrayPool;
import sunny.arraylist.LongArray;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledUnsafeLongArray extends PooledUnsafeArray implements LongArray {

    private int size;

    public PooledUnsafeLongArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(long value) {
        ensureCapacity(size);
        array.putLong(size * Long.BYTES, value);
        size++;
    }

    @Override
    public void set(int index, long value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        array.putLong(index * Long.BYTES, value);
    }

    @Override
    public long get(int index) {
        return array.getLong(index * Long.BYTES);
    }
}
