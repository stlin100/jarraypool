package sunny.arraylist.pooled;

import sunny.array.pool.unsafe.UnsafeIntArrayPool;
import sunny.array.pool.unsafe.UnsafeLongArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.LongArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledLongArrayList extends UnsafePooledLongArray implements ArrayList, LongArrayList {

    public UnsafePooledLongArrayList(UnsafeLongArrayPool pool, int capacity) {
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
