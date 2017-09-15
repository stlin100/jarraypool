package sunny.arraylist.unpooled;

import sunny.arraylist.IntArrayList;
import sunny.arraylist.ShortArrayList;

import java.util.Arrays;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledShortArrayList extends UnpooledShortArray implements ShortArrayList {
    public UnpooledShortArrayList(int capacity) {
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
}
