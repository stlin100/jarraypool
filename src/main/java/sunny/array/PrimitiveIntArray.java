package sunny.array;

import java.util.Arrays;

/**
 * Created by lzx on 17/8/30.
 */
public class PrimitiveIntArray implements IntArray{

    private int capacity;
    private int[] elements = null;

    private int size;

    public PrimitiveIntArray()
    {
        this(64);
    }

    public PrimitiveIntArray(int initialCapacity)
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

    private final void ensureCapacity(int index) {
        if(index>capacity - 1)
        {
            capacity = capacity + (capacity>>1);
            elements = Arrays.copyOf(elements, capacity);

        }
    }

    @Override
    public final int get(int index) {
        //assert index < size;
        return elements[index];
    }

    @Override
    public final void free() {
        elements = null;
    }
}
