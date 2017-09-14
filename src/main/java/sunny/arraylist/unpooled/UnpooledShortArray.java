package sunny.arraylist.unpooled;

import sunny.arraylist.IntArray;
import sunny.arraylist.ShortArray;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledShortArray implements ShortArray {

    protected int capacity;
    protected short[] elements = null;

    private int size;

    public UnpooledShortArray(int initialCapacity)
    {
        capacity = initialCapacity;
        elements = new short[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void set(int index, short value) {
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
    public final short get(int index) {
        return elements[index];
    }

    @Override
    public final void free() {
        elements = null;
    }
}
