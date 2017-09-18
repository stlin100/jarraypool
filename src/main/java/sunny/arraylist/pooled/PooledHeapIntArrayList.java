package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.IntArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapIntArrayList extends PooledHeapIntArray implements ArrayList, IntArrayList {
    public PooledHeapIntArrayList(ArrayPool<int[]> pool, int capacity) {
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
