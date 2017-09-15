package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeIntArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.IntArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledIntArrayList extends UnsafePooledIntArray implements ArrayList, IntArrayList {

    public UnsafePooledIntArrayList(UnsafeIntArrayPool pool, int capacity) {
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
