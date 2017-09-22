package sunny.arraylist.unpooled;

import sunny.arraylist.IntArray;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeIntArray extends UnpooledUnsafeArray implements IntArray {
    protected int capacity;

    private int size;

    public UnpooledUnsafeIntArray(int initialCapacity)
    {
        super(Integer.BYTES * initialCapacity);
        capacity = initialCapacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(int value) {
        ensureCapacity(size);

        memory.putInt(Integer.BYTES * size++, value);
    }

    @Override
    public final void set(int index, int value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        memory.putInt(Integer.BYTES * index, value);

    }

    protected void ensureCapacity(int index) {
    }


    @Override
    public final int get(int index) {
        return memory.getInt(Integer.BYTES * index);
    }

}
