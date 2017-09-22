package sunny.arraylist.pooled;

import sunny.arraylist.BooleanArray;
import sunny.arraypool.ArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapBooleanArray extends PooledArray<boolean[]> implements BooleanArray {

    private int size;

    public PooledHeapBooleanArray(ArrayPool<boolean[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(boolean value) {
        ensureCapacity(size);
        array[size] = value;
        size++;
    }

    @Override
    public void set(int index, boolean value) {
        ensureCapacity(index);

        if(index>=size)
        {
            size = index + 1;
        }
        array[index] = value;
    }

    @Override
    public boolean get(int index) {
        return array[index];
    }
}
