package sunny.arraylist.unpooled;

import sunny.arraylist.ArrayList;
import sunny.arraylist.LongArrayList;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeLongArrayList extends UnpooledUnsafeLongArray implements LongArrayList {


    public UnpooledUnsafeLongArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void ensureCapacity(int index) {
        if(index>=capacity)
        {
            do
            {
                capacity = capacity<<1;
            }while(index>=capacity);
            memory.reallocate(Long.BYTES * capacity);
        }
    }
}
