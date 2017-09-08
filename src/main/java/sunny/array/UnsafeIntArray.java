package sunny.array;

import sunny.memory.UnsafeOffHeapMemory;

/**
 * Created by lzx on 17/8/30.
 */
public class UnsafeIntArray implements IntArray {

    private final int BYTES = 4;
    private int size;
    private int capacity;

    UnsafeOffHeapMemory memory;

    public UnsafeIntArray()
    {
        this(64);
    }

    public UnsafeIntArray(int initialCapacity)
    {
        memory = new UnsafeOffHeapMemory(initialCapacity * BYTES);
        this.capacity = initialCapacity;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, int value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }

        memory.putInt(index * BYTES, value);
    }

    private void ensureCapacity(int index) {
        if(index>capacity - 1)
        {
            capacity += capacity >> 1;
            memory.reallocate(capacity * BYTES);
        }
    }

    @Override
    public int get(int index) {
        assert  index < size;
        return memory.getInt(index * BYTES);
    }

    @Override
    public void free() {
        memory.free();
    }
}
