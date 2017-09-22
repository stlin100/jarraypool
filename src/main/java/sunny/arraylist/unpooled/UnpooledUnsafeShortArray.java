package sunny.arraylist.unpooled;

import sunny.arraylist.ShortArray;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeShortArray extends UnpooledUnsafeArray implements ShortArray {
    protected int capacity;
    protected UnsafeMemory memory = null;

    private int size;

    public UnpooledUnsafeShortArray(int initialCapacity)
    {
        super(Short.BYTES * initialCapacity);
        capacity = initialCapacity;
        memory = new UnsafeMemory(Short.BYTES * initialCapacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(short value) {
        ensureCapacity(size);
        memory.putShort(size * Short.BYTES, value);
        size++;
    }

    @Override
    public void set(int index, short value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        memory.putShort(index * Short.BYTES, value);
    }

    @Override
    public short get(int index) {
        return memory.getShort(index * Short.BYTES);
    }

}
