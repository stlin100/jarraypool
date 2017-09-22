package sunny.arraylist.pooled;

import sunny.arraylist.ArrayList;
import sunny.arraylist.CharArrayList;
import sunny.arraypool.unsafe.UnsafeCharArrayPool;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledUnsafeCharArrayList extends PooledUnsafeCharArray implements ArrayList, CharArrayList {

    public PooledUnsafeCharArrayList(UnsafeCharArrayPool pool, int capacity) {
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


    @Override
    public int compareTo(CharArrayList another) {
        return super.compareTo(another);
    }
}
