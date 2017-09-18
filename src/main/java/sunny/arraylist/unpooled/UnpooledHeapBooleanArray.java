package sunny.arraylist.unpooled;

import sunny.arraylist.BooleanArray;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledHeapBooleanArray extends UnpooledHeapArray implements BooleanArray {

    protected int capacity;
    protected boolean[] elements = null;

    private int size;

    public UnpooledHeapBooleanArray(int initialCapacity)
    {
        capacity = initialCapacity;
        elements = new boolean[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void set(int index, boolean value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        elements[index] = value;

    }

    @Override
    public void append(boolean value) {
        ensureCapacity(size);
        elements[size] = value;
        size++;
    }

    protected void ensureCapacity(int index) {
    }


    @Override
    public final boolean get(int index) {
        return elements[index];
    }

    @Override
    public final void free() {
        elements = null;
    }
}
