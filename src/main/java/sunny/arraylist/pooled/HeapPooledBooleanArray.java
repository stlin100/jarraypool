package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.BooleanArray;

/**
 * Created by lzx on 17/9/8.
 */
public class HeapPooledBooleanArray extends PooledArray<boolean[]> implements BooleanArray {

    private int size;

    public HeapPooledBooleanArray(ArrayPool<boolean[]> pool, int capacity) {
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
