package sunny.arraylist.pooled;

import sunny.arraylist.IntArray;
import sunny.arraypool.ArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapIntArray extends PooledArray<int[]> implements IntArray{

    private int size;

    public PooledHeapIntArray(ArrayPool<int[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(int value) {
        ensureCapacity(size);
        array[size] = value;
        size++;
    }

    @Override
    public void set(int index, int value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        array[index] = value;
    }

    @Override
    public int get(int index) {
        return array[index];
    }
}
