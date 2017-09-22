package sunny.arraylist.unpooled;

import sunny.arraylist.BooleanArray;
import sunny.arraylist.metric.MetricSystem;

import java.util.BitSet;

/**
 * don't need metric, GC free.
 * Created by lzx on 17/9/14.
 */
public class UnpooledHeapBooleanArray extends UnpooledHeapArray implements BooleanArray {

    protected int capacity;
    //protected boolean[] elements = null;
    protected BitSet elements = new BitSet();
    private int size;

    public UnpooledHeapBooleanArray(int initialCapacity)
    {
        capacity = initialCapacity;
        //elements = new boolean[initialCapacity];
        //MetricSystem.unpooledAllocHeapSize.inc(capacity * Byte.BYTES);
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
        //elements[index] = value;
        elements.set(index, value);
    }

    @Override
    public void append(boolean value) {
        ensureCapacity(size);
        //elements[size] = value;
        elements.set(size++, value);
    }

    protected void ensureCapacity(int index) {
    }


    @Override
    public final boolean get(int index) {
        return elements.get(index);
    }

    @Override
    public final void free() {
        elements = null;
        //MetricSystem.unpooledAllocHeapSize.dec(capacity * Byte.BYTES);
    }
}
