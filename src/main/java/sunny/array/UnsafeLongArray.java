package sunny.array;

import sunny.memory.UnsafeOffHeapMemory;

/**
 * Created by lzx on 17/8/30.
 */
public class UnsafeLongArray implements LongArray {

    private final int BYTES = 8;
    private int size;
    private int capacity;

    UnsafeOffHeapMemory memory;

    public UnsafeLongArray()
    {
        this(64);
    }

    public UnsafeLongArray(int initialCapacity)
    {
        memory = new UnsafeOffHeapMemory(initialCapacity * BYTES);
        this.capacity = initialCapacity;
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

        memory.putLong(index * BYTES, value);
    }

    private void ensureCapacity(int index) {
        if(index>capacity - 1)
        {
            capacity += capacity >> 1;
            memory.reallocate(capacity * BYTES);
        }
    }

    @Override
    public long get(int index) {
        assert  index < size;
        return memory.getLong(index * BYTES);
    }

    @Override
    public void free() {
        memory.free();
    }
}
