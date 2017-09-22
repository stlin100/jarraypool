package sunny.arraylist.unpooled;

import sunny.arraylist.CharArrayList;
import sunny.arraylist.metric.MetricSystem;

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
            int oldCapacity = capacity;
            do
            {
                capacity = capacity<<1;
            }while(index>=capacity);
            elements = Arrays.copyOf(elements, capacity);

            MetricSystem.unpooledAllocHeapSize.inc((capacity - oldCapacity) * Character.BYTES);
        }
    }

    @Override
    public int compareTo(CharArrayList another) {
        return super.compareTo(another);
    }


}
