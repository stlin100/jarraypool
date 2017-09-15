package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeArrayPool;
import sunny.arraylist.BooleanArray;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledBooleanArray extends UnsafePooledArray implements BooleanArray {

    private int size;

    public UnsafePooledBooleanArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void append(boolean value) {
        ensureCapacity(size);
        array.putByte(size * Byte.BYTES, (byte)(value?1:0));
        size++;
    }

    @Override
    public void set(int index, boolean value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        array.putByte(index * Byte.BYTES, (byte)(value?1:0));
    }

    @Override
    public boolean get(int index) {
        return array.getByte(index * Byte.BYTES)==1;
    }
}
