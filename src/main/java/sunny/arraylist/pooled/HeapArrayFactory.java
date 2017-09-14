package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPoolFactory;
import sunny.arraylist.*;
import sunny.arraypool.heap.*;

/**
 * Created by lzx on 17/9/8.
 */
public class HeapArrayFactory extends ArrayFactory{

    HeapArrayPoolFactory poolFactory;

    HeapIntArrayPool intArrayPool;
    HeapLongArrayPool longArrayPool;
    HeapShortArrayPool shortArrayPool;
    HeapCharArrayPool charArrayPool;
    HeapBooleanArrayPool booleanArrayPool;

    private Builder builder;

    public HeapArrayFactory(Builder builder)
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
        return new HeapPooledIntArray(intArrayPool, capacity);
    }

    @Override
    public IntArrayList createIntArrayList(int capacity) {
        return new HeapPooledIntArrayList(intArrayPool, capacity);
    }

    @Override
    public LongArray createLongArray(int capacity) {
        return new HeapPooledLongArray(longArrayPool, capacity);
    }

    @Override
    public LongArrayList createLongArrayList(int capacity) {
        return new HeapPooledLongArrayList(longArrayPool, capacity);
    }

    @Override
    public BooleanArray createBooleanArray(int capacity) {
        return new HeapPooledBooleanArray(booleanArrayPool, capacity);
    }

    @Override
    public BooleanArrayList createBooleanArrayList(int capacity) {
        return new HeapPooledBooleanArrayList(booleanArrayPool, capacity);
    }

    @Override
    public ShortArray createShortArray(int capacity) {
        return new HeapPooledShortArray(shortArrayPool, capacity);
    }

    @Override
    public ShortArrayList createShortArrayList(int capacity) {
        return new HeapPooledShortArrayList(shortArrayPool, capacity);
    }

    @Override
    public CharArray createCharArray(int capacity) {
        return new HeapPooledCharArray(charArrayPool, capacity);
    }

    @Override
    public CharArrayList createCharArrayList(int capacity) {
        return new HeapPooledCharArrayList(charArrayPool, capacity);
    }

}
