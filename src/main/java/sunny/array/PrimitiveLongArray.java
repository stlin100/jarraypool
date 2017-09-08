package sunny.array;

import java.util.Arrays;

/**
 * Created by lzx on 17/8/30.
 */
public class PrimitiveLongArray implements LongArray{

    private long[] elements = null;

    private int size;

    public PrimitiveLongArray()
    {
        this(64);
    }

    public PrimitiveLongArray(int initialCapacity)
    {
        elements = new long[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, long value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }
        elements[index] = value;

    }

    private void ensureCapacity(int index) {
        if(index>elements.length - 1)
            elements = Arrays.copyOf(elements, elements.length + (elements.length>>1));
    }

    @Override
    public long get(int index) {
        assert index < size;
        return elements[index];
    }

    @Override
    public void free() {
        elements = null;
    }
}
