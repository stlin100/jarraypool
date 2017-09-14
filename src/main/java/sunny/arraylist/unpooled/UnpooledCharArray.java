package sunny.arraylist.unpooled;

import sunny.arraylist.CharArray;
import sunny.arraylist.IntArray;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledCharArray implements CharArray {

    protected int capacity;
    protected char[] elements = null;

    private int size;

    public UnpooledCharArray(int initialCapacity)
    {
        capacity = initialCapacity;
        elements = new char[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void set(int index, char value) {
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
    public final char get(int index) {
        return elements[index];
    }

    @Override
    public final void free() {
        elements = null;
    }
}
