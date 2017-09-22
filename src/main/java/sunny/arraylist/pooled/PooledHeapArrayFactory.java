package sunny.arraylist.pooled;

import sunny.arraylist.*;
import sunny.arraypool.ArrayPoolFactory;
import sunny.arraypool.heap.*;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapArrayFactory extends ArrayFactory{

    HeapArrayPoolFactory poolFactory;

    HeapIntArrayPool intArrayPool;
    HeapLongArrayPool longArrayPool;
    HeapShortArrayPool shortArrayPool;
    HeapCharArrayPool charArrayPool;
    HeapBooleanArrayPool booleanArrayPool;

    private Builder builder;

    public PooledHeapArrayFactory(Builder builder)
    {
        this.builder = builder;

        poolFactory = ArrayPoolFactory.heap();

        if(builder.getIntMinLevelSize()>0)
            intArrayPool = (HeapIntArrayPool) poolFactory.createIntArrayPool(builder.getIntMinLevelSize(), builder.getIntMaxLevelSize(), builder.getIntDeamonRunner());

        if(builder.getLongMinLevelSize()>0)
            longArrayPool = (HeapLongArrayPool) poolFactory.createLongArrayPool(builder.getLongMinLevelSize(), builder.getLongMaxLevelSize(), builder.getLongDeamonRunner());

        if(builder.getShortMinLevelSize()>0)
            shortArrayPool = (HeapShortArrayPool) poolFactory.createShortArrayPool(builder.getShortMinLevelSize(), builder.getShortMaxLevelSize(), builder.getShortDeamonRunner());

        if(builder.getCharMinLevelSize()>0)
            charArrayPool = (HeapCharArrayPool) poolFactory.createCharArrayPool(builder.getCharMinLevelSize(), builder.getCharMaxLevelSize(), builder.getCharDeamonRunner());

        if(builder.getBooleanMinLevelSize()>0)
            booleanArrayPool = (HeapBooleanArrayPool) poolFactory.createBooleanArrayPool(builder.getBooleanMinLevelSize(), builder.getBooleanMaxLevelSize(), builder.getBooleanDeamonRunner());
    }

    @Override
    public IntArray createIntArray(int capacity) {
        return new PooledHeapIntArray(intArrayPool, capacity);
    }

    @Override
    public IntArrayList createIntArrayList(int capacity) {
        return new PooledHeapIntArrayList(intArrayPool, capacity);
    }

    @Override
    public LongArray createLongArray(int capacity) {
        return new PooledHeapLongArray(longArrayPool, capacity);
    }

    @Override
    public LongArrayList createLongArrayList(int capacity) {
        return new PooledHeapLongArrayList(longArrayPool, capacity);
    }

    @Override
    public BooleanArray createBooleanArray(int capacity) {
        return new PooledHeapBooleanArray(booleanArrayPool, capacity);
    }

    @Override
    public BooleanArrayList createBooleanArrayList(int capacity) {
        return new PooledHeapBooleanArrayList(booleanArrayPool, capacity);
    }

    @Override
    public ShortArray createShortArray(int capacity) {
        return new PooledHeapShortArray(shortArrayPool, capacity);
    }

    @Override
    public ShortArrayList createShortArrayList(int capacity) {
        return new PooledHeapShortArrayList(shortArrayPool, capacity);
    }

    @Override
    public CharArray createCharArray(int capacity) {
        return new PooledHeapCharArray(charArrayPool, capacity);
    }

    @Override
    public CharArrayList createCharArrayList(int capacity) {
        return new PooledHeapCharArrayList(charArrayPool, capacity);
    }

}
