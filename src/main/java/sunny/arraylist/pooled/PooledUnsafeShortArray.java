package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeArrayPool;
import sunny.arraylist.ShortArray;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledUnsafeShortArray extends PooledUnsafeArray implements ShortArray {

    private int size;

    public PooledUnsafeShortArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(short value) {
        ensureCapacity(size);
        array.putShort(size * Short.BYTES, value);
        size++;
    }

    @Override
    public void set(int index, short value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        array.putShort(index * Short.BYTES, value);
    }

    @Override
    public short get(int index) {
        return array.getShort(index * Short.BYTES);
    }
}
