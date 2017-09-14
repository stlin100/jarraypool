package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.CharArray;

/**
 * Created by lzx on 17/9/8.
 */
public class HeapPooledCharArray extends PooledArray<char[]> implements CharArray {

    private int size;

    public HeapPooledCharArray(ArrayPool<char[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, char value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }
        array[index] = value;
    }

    @Override
    public char get(int index) {
        return array[index];
    }
}
