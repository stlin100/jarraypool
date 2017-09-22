package sunny.arraylist.pooled;

import sunny.arraylist.ArrayList;
import sunny.arraylist.IntArrayList;
import sunny.arraypool.unsafe.UnsafeIntArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledUnsafeIntArrayList extends PooledUnsafeIntArray implements ArrayList, IntArrayList {

    public PooledUnsafeIntArrayList(UnsafeIntArrayPool pool, int capacity) {
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
