package sunny.array;

import sunny.memory.UnsafeOffHeapMemory;

/**
 * Created by lzx on 17/8/30.
 */
public class UnsafeShortArray implements ShortArray {

    private final int BYTES = 2;
    private int size;
    private int capacity;

    UnsafeOffHeapMemory memory;

    public UnsafeShortArray()
    {
        this(64);
    }

    public UnsafeShortArray(int initialCapacity)
    {
        memory = new UnsafeOffHeapMemory(initialCapacity * BYTES);
        this.capacity = initialCapacity;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, short value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }

        memory.putShort(index * BYTES, value);
    }

    private void ensureCapacity(int index) {
        if(index>capacity - 1)
        {
            capacity += capacity >> 1;
            memory.reallocate(capacity * BYTES);
        }
    }

    @Override
    public short get(int index) {
        assert  index < size;
        return memory.getShort(index * BYTES);
    }

    @Override
    public void free() {
        memory.free();
    }
}
