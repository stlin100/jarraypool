package sunny.arraylist.unpooled;

import sunny.arraylist.IntArrayList;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeIntArrayList extends UnpooledUnsafeIntArray implements IntArrayList {


    public UnpooledUnsafeIntArrayList(int initialCapacity) {
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
            reallocate(Integer.BYTES * capacity);
        }
    }
}
