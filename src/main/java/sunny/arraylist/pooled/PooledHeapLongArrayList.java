package sunny.arraylist.pooled;

import sunny.arraylist.ArrayList;
import sunny.arraylist.LongArrayList;
import sunny.arraypool.ArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapLongArrayList extends PooledHeapLongArray implements ArrayList, LongArrayList {
    public PooledHeapLongArrayList(ArrayPool<long[]> pool, int capacity) {
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
