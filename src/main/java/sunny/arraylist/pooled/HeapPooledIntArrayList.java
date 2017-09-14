package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.IntArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class HeapPooledIntArrayList extends HeapPooledIntArray implements ArrayList, IntArrayList {
    public HeapPooledIntArrayList(ArrayPool<int[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public void ensureCapacity(int index) {
        if(index>capacity - 1)
        {
            capacity = capacity << 1;
            array = pool.extend(array, capacity);
        }
    }
}
