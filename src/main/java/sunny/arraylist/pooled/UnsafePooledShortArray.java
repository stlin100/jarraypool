package sunny.arraylist.pooled;

import sunny.array.pool.unsafe.UnsafeArrayPool;
import sunny.arraylist.IntArray;
import sunny.arraylist.ShortArray;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledShortArray extends UnsafePooledArray implements ShortArray {

    private int size;

    public UnsafePooledShortArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, short value) {
        if(size<index+1)
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
