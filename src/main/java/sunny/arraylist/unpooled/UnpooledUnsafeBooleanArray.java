package sunny.arraylist.unpooled;

import sunny.arraylist.BooleanArray;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeBooleanArray extends UnpooledUnsafeArray implements BooleanArray {


    protected int capacity;
    private int size;

    public UnpooledUnsafeBooleanArray(int initialCapacity)
    {
        super(Byte.BYTES * initialCapacity);
        capacity = initialCapacity;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(boolean value) {
        ensureCapacity(size);
        memory.putByte(size * Byte.BYTES, (byte)(value?1:0));
        size++;
    }

    @Override
    public void set(int index, boolean value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        memory.putByte(index * Byte.BYTES, (byte)(value?1:0));
    }

    @Override
    public boolean get(int index) {
        return memory.getByte(index * Byte.BYTES)==1;
    }

}
