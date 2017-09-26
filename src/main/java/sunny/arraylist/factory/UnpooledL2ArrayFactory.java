package sunny.arraylist.factory;

import sunny.arraylist.*;
import sunny.arraylist.metric.Metrics;
import sunny.arraylist.unpooled.UnpooledHeapArrayFactory;
import sunny.arraylist.unpooled.UnpooledUnsafeArrayFactory;

/**
 * L2: level 2 allocate, unpooled heap first then unsafe
 * Created by lzx on 17/9/22.
 */
public class UnpooledL2ArrayFactory extends ArrayFactory implements UnpooledL2ArrayFactoryMBean {

    private int totalHeapLimit;
    private int heapAllocateCapacityLimit;

    private UnpooledUnsafeArrayFactory unsafeFactory;
    private UnpooledHeapArrayFactory heapFactory;

    public UnpooledL2ArrayFactory(int totalHeapLimit, int heapAllocateCapacityLimit)
    {

        this.totalHeapLimit = totalHeapLimit;
        this.heapAllocateCapacityLimit = heapAllocateCapacityLimit;

        unsafeFactory = new UnpooledUnsafeArrayFactory();
        heapFactory = new UnpooledHeapArrayFactory();
    }

    private boolean useUnsafe(int capacity)
    {
        return
                (
                (Metrics.unpooledAllocHeapSize.getCount()>totalHeapLimit)
                        ||
                        (heapAllocateCapacityLimit>0 && capacity > heapAllocateCapacityLimit)
                );
    }

    @Override
    public IntArray createIntArray(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createIntArray(capacity);

        return heapFactory.createIntArray(capacity);
    }

    @Override
    public IntArrayList createIntArrayList(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createIntArrayList(capacity);

        return heapFactory.createIntArrayList(capacity);
    }

    @Override
    public LongArray createLongArray(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createLongArray(capacity);

        return heapFactory.createLongArray(capacity);
    }

    @Override
    public LongArrayList createLongArrayList(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createLongArrayList(capacity);

        return heapFactory.createLongArrayList(capacity);
    }

    @Override
    public BooleanArray createBooleanArray(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createBooleanArray(capacity);

        return heapFactory.createBooleanArray(capacity);
    }

    @Override
    public BooleanArrayList createBooleanArrayList(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createBooleanArrayList(capacity);

        return heapFactory.createBooleanArrayList(capacity);
    }

    @Override
    public ShortArray createShortArray(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createShortArray(capacity);

        return heapFactory.createShortArray(capacity);
    }

    @Override
    public ShortArrayList createShortArrayList(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createShortArrayList(capacity);

        return heapFactory.createShortArrayList(capacity);
    }

    @Override
    public CharArray createCharArray(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createCharArray(capacity);

        return heapFactory.createCharArray(capacity);
    }

    @Override
    public CharArrayList createCharArrayList(int capacity) {
        if(useUnsafe(capacity))
            return unsafeFactory.createCharArrayList(capacity);

        return heapFactory.createCharArrayList(capacity);
    }

    @Override
    public void setTotalHeapLimit(int limit) {
        this.totalHeapLimit = limit;
    }

    @Override
    public int getTotalHeapLimit() {
        return totalHeapLimit;
    }

    @Override
    public void setHeapAllocateCapacityLimit(int limit) {
        this.heapAllocateCapacityLimit = limit;
    }

    @Override
    public int getHeapAllocateCapacityLimit() {
        return heapAllocateCapacityLimit;
    }


}
