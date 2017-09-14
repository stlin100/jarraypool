package sunny.arraylist.unpooled;

import sunny.arraylist.CharArrayList;
import sunny.arraylist.IntArrayList;

import java.util.Arrays;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledCharArrayList extends UnpooledCharArray implements CharArrayList {
    public UnpooledCharArrayList(int capacity) {
        super(capacity);
    }


    public final void ensureCapacity(int index) {
        if(index>capacity - 1)
        {
            capacity = capacity + (capacity>>1);
            elements = Arrays.copyOf(elements, capacity);

        }
    }
}