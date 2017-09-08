package sunny.arraylist.pooled;

import sunny.array.pool.ArrayPool;
import sunny.array.pool.unsafe.UnsafeArrayPool;
import sunny.arraylist.IntArray;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledIntArray extends UnsafePooledArray implements IntArray{

    private int size;

    public UnsafePooledIntArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, int value) {
        if(size<index+1)
        {
            size = index + 1;
        }
        array.putInt(index * Integer.BYTES, value);
    }

    @Override
    public int get(int index) {
        return array.getInt(index * Integer.BYTES);
    }
}
