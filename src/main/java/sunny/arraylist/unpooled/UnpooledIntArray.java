package sunny.arraylist.unpooled;

import sunny.arraylist.IntArray;

import java.util.Arrays;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledIntArray implements IntArray {

    protected int capacity;
    protected int[] elements = null;

    private int size;

    public UnpooledIntArray(int initialCapacity)
    {
        capacity = initialCapacity;
        elements = new int[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void set(int index, int value) {
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
    public final int get(int index) {
        return elements[index];
    }

    @Override
    public final void free() {
        elements = null;
    }
}