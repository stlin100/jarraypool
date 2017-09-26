package sunny.arraylist.unpooled;

import sunny.arraylist.BooleanArrayList;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledHeapBooleanArrayList extends UnpooledHeapBooleanArray implements BooleanArrayList {
    public UnpooledHeapBooleanArrayList(int capacity) {
        super(capacity);
    }


    /**
     * BitSet will extends automatically
     * @param index
     */
    public final void ensureCapacity(int index) {
        /*
        if(index>=capacity)
        {
            int old = capacity;
            do
            {
                capacity = capacity<<1;
            }while(index>=capacity);
            elements = Arrays.copyOf(elements, capacity);
            Metrics.unpooledAllocHeapSize.inc((capacity - old) * Byte.BYTES);
        }
        */
    }
}
