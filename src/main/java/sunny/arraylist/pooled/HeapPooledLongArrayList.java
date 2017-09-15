package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.LongArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class HeapPooledLongArrayList extends HeapPooledLongArray implements ArrayList, LongArrayList {
    public HeapPooledLongArrayList(ArrayPool<long[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public void ensureCapacity(int index) {
        if(index>=capacity)
        {
            do
            {
                capacity = capacity<<1;
            }while(index>=capacity);
            array = pool.extend(array, capacity);
        }
    }
}
