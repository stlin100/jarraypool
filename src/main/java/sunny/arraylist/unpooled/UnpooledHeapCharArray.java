package sunny.arraylist.unpooled;

import sunny.arraylist.CharArray;
import sunny.arraylist.metric.MetricSystem;
import sunny.util.CharArrayCompares;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledHeapCharArray extends UnpooledHeapArray implements CharArray {

    protected int capacity;
    protected char[] elements = null;

    private int size;

    public UnpooledHeapCharArray(int initialCapacity)
    {
        capacity = initialCapacity;
        elements = new char[initialCapacity];
        MetricSystem.unpooledAllocHeapSize.inc(capacity * Character.BYTES);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void set(int index, char value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        elements[index] = value;

    }

    @Override
    public void append(char value) {
        ensureCapacity(size);
        elements[size] = value;
        size++;
    }

    protected void ensureCapacity(int index) {
    }

    @Override
    public char[] nativeChars() {
        return elements;
    }

    @Override
    public final char get(int index) {
        return elements[index];
    }


    @Override
    public int compareTo(CharArray another) {
        char[] chars2 = another.nativeChars();
        if(chars2!=null)
            return CharArrayCompares.compare(elements, size, chars2, another.size());
        else
            return CharArrayCompares.compare(elements, size, another, another.size());
    }

    @Override
    public final void free() {
        elements = null;
        MetricSystem.unpooledAllocHeapSize.dec(capacity * Character.BYTES);
    }


}
