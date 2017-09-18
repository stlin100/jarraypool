package sunny.arraylist.unpooled;

import sunny.arraylist.ArrayList;
import sunny.arraylist.CharArrayList;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeCharArrayList extends UnpooledUnsafeCharArray implements CharArrayList {


    public UnpooledUnsafeCharArrayList(int initialCapacity) {
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
            memory.reallocate(Character.BYTES * capacity);
        }
    }

    @Override
    public int compareTo(CharArrayList another) {
        return super.compareTo(another);
    }
}
