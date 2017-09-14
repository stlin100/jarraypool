package sunny.arraylist.unpooled;

import sunny.arraylist.BooleanArray;
import sunny.arraylist.IntArray;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledBooleanArray implements BooleanArray {

    protected int capacity;
    protected boolean[] elements = null;

    private int size;

    public UnpooledBooleanArray(int initialCapacity)
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
        if(size<index+1)
        {
            size = index + 1;
        }
        elements[index] = value;

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
