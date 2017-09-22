package sunny.arraylist.unpooled;

import sunny.arraylist.LongArray;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeLongArray extends UnpooledUnsafeArray implements LongArray {
    protected int capacity;

    private int size;

    public UnpooledUnsafeLongArray(int initialCapacity)
    {
        super(Long.BYTES * initialCapacity);
        capacity = initialCapacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(long value) {
        ensureCapacity(size);
        memory.putLong(size * Long.BYTES, value);
        size++;
    }

    @Override
    public void set(int index, long value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        memory.putLong(index * Long.BYTES, value);
    }

    @Override
    public long get(int index) {
        return memory.getLong(index * Long.BYTES);
    }

}
