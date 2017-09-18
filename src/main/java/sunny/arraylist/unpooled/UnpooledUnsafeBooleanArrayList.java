package sunny.arraylist.unpooled;

import sunny.arraylist.ArrayList;
import sunny.arraylist.BooleanArrayList;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeBooleanArrayList extends UnpooledUnsafeBooleanArray implements BooleanArrayList {


    public UnpooledUnsafeBooleanArrayList(int initialCapacity) {
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
            memory.reallocate(Byte.BYTES * capacity);
        }
    }
}
