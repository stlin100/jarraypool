package sunny.arraylist.unpooled;

import sunny.arraylist.CharArrayList;

import java.util.Arrays;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledHeapCharArrayList extends UnpooledHeapCharArray implements CharArrayList {
    public UnpooledHeapCharArrayList(int capacity) {
        super(capacity);
    }


    public final void ensureCapacity(int index) {
        if(index>=capacity)
        {
            do
            {
                capacity = capacity<<1;
            }while(index>=capacity);
            elements = Arrays.copyOf(elements, capacity);

        }
    }

    @Override
    public int compareTo(CharArrayList another) {
        return super.compareTo(another);
    }


}
