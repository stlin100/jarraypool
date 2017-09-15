package sunny.arraylist.unpooled;

import sunny.arraylist.IntArrayList;
import sunny.arraylist.LongArrayList;

import java.util.Arrays;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledLongArrayList extends UnpooledLongArray implements LongArrayList {
    public UnpooledLongArrayList(int capacity) {
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
