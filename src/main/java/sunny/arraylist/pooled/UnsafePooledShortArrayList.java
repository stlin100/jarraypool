package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeShortArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.ShortArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledShortArrayList extends UnsafePooledShortArray implements ArrayList, ShortArrayList {

    public UnsafePooledShortArrayList(UnsafeShortArrayPool pool, int capacity) {
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
