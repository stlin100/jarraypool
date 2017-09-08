package sunny.arraylist.pooled;

import sunny.array.pool.unsafe.UnsafeArrayPool;
import sunny.arraylist.CharArray;
import sunny.arraylist.IntArray;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledCharArray extends UnsafePooledArray implements CharArray {

    private int size;

    public UnsafePooledCharArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, char value) {
        if(size<index+1)
        {
            size = index + 1;
        }
        array.putShort(index * Short.BYTES, (short)value);
    }

    @Override
    public char get(int index) {
        return (char)array.getShort(index * Short.BYTES);
    }
}
