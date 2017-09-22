package sunny.arraylist.unpooled;

import sunny.arraylist.ShortArrayList;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeShortArrayList extends UnpooledUnsafeShortArray implements ShortArrayList {


    public UnpooledUnsafeShortArrayList(int initialCapacity) {
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
            reallocate(Short.BYTES * capacity);
        }
    }
}
