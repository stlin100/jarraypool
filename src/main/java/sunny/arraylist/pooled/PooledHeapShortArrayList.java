package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.ShortArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapShortArrayList extends PooledHeapShortArray implements ArrayList, ShortArrayList {
    public PooledHeapShortArrayList(ArrayPool<short[]> pool, int capacity) {
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
