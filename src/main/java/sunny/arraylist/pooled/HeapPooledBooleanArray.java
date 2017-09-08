package sunny.arraylist.pooled;

import sunny.array.pool.ArrayPool;
import sunny.arraylist.BooleanArray;
import sunny.arraylist.IntArray;

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
    public void set(int index, boolean value) {
        if(size<index+1)
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
