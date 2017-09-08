package sunny.arraylist.pooled;

import sunny.array.pool.unsafe.UnsafeCharArrayPool;
import sunny.array.pool.unsafe.UnsafeIntArrayPool;
import sunny.arraylist.ArrayList;
import sunny.arraylist.CharArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafePooledCharArrayList extends UnsafePooledCharArray implements ArrayList, CharArrayList {

    public UnsafePooledCharArrayList(UnsafeCharArrayPool pool, int capacity) {
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
