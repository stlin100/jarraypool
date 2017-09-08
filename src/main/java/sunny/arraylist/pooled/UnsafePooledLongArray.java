package sunny.arraylist.pooled;

import sunny.array.pool.unsafe.UnsafeArrayPool;
import sunny.arraylist.IntArray;
import sunny.arraylist.LongArray;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledLongArray extends UnsafePooledArray implements LongArray {

    private int size;

    public UnsafePooledLongArray(UnsafeArrayPool pool, int capacity) {
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
        array.putLong(index * Long.BYTES, value);
    }

    @Override
    public long get(int index) {
        return array.getLong(index * Long.BYTES);
    }
}
