package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.BooleanArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class HeapPooledBooleanArrayList extends HeapPooledBooleanArray implements ArrayList, BooleanArrayList {
    public HeapPooledBooleanArrayList(ArrayPool<boolean[]> pool, int capacity) {
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
