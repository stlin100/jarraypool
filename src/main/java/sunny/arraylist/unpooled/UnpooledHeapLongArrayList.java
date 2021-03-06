package sunny.arraylist.unpooled;

import sunny.arraylist.LongArrayList;
import sunny.arraylist.metric.Metrics;

import java.util.Arrays;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledHeapLongArrayList extends UnpooledHeapLongArray implements LongArrayList {
    public UnpooledHeapLongArrayList(int capacity) {
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


            Metrics.unpooledAllocHeapSize.inc((capacity - oldCapacity) * Long.BYTES);

        }
    }
}
