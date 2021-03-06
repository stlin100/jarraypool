package sunny.arraylist.unpooled;

import sunny.arraylist.IntArray;
import sunny.arraylist.metric.Metrics;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledHeapIntArray extends UnpooledHeapArray implements IntArray {

    protected int capacity;
    protected int[] elements = null;

    private int size;

    public UnpooledHeapIntArray(int initialCapacity)
    {
        capacity = initialCapacity;
        elements = new int[initialCapacity];
        Metrics.unpooledAllocHeapSize.inc(capacity * Integer.BYTES);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(int value) {
        ensureCapacity(size);
        elements[size] = value;
        size++;
    }

    @Override
    public final void set(int index, int value) {
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
    public final int get(int index) {
        return elements[index];
    }

    @Override
    public final void free() {
        elements = null;
        Metrics.unpooledAllocHeapSize.dec(capacity * Integer.BYTES);
    }
}
