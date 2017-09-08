package sunny.arraylist.pooled;

import sunny.array.pool.ArrayPool;
import sunny.arraylist.IntArray;
import sunny.arraylist.ShortArray;

/**
 * Created by lzx on 17/9/8.
 */
public class HeapPooledShortArray extends PooledArray<short[]> implements ShortArray {

    private int size;

    public HeapPooledShortArray(ArrayPool<short[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, short value) {
        if(size<index+1)
        {
            size = index + 1;
        }
        array[index] = value;
    }

    @Override
    public short get(int index) {
        return array[index];
    }
}
