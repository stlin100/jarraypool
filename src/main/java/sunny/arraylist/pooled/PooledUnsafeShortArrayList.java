package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeShortArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.ShortArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledUnsafeShortArrayList extends PooledUnsafeShortArray implements ArrayList, ShortArrayList {

    public PooledUnsafeShortArrayList(UnsafeShortArrayPool pool, int capacity) {
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
