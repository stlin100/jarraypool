package sunny.arraylist.pooled;

import sunny.arraylist.ArrayList;
import sunny.arraylist.BooleanArrayList;
import sunny.arraypool.unsafe.UnsafeBooleanArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledUnsafeBooleanArrayList extends PooledUnsafeBooleanArray implements ArrayList, BooleanArrayList {

    public PooledUnsafeBooleanArrayList(UnsafeBooleanArrayPool pool, int capacity) {
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
