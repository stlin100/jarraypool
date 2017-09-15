package sunny.arraylist.unpooled;

import sunny.arraylist.IntArray;
import sunny.arraylist.LongArray;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledLongArray implements LongArray {

    protected int capacity;
    protected long[] elements = null;

    private int size;

    public UnpooledLongArray(int initialCapacity)
    {
        capacity = initialCapacity;
        elements = new long[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(long value) {
        ensureCapacity(size);
        elements[size] = value;
        size++;
    }

    @Override
    public final void set(int index, long value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        elements[index] = value;

    }

    protected void ensureCapacity(int index) {
    }


    @Override
    public final long get(int index) {
        return elements[index];
    }

    @Override
    public final void free() {
        elements = null;
    }
}
