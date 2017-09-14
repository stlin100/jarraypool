package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPoolFactory;
import sunny.arraylist.*;
import sunny.arraypool.unsafe.*;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafeArrayFactory extends ArrayFactory{

    UnsafeArrayPoolFactory poolFactory;

    UnsafeIntArrayPool intArrayPool;
    UnsafeLongArrayPool longArrayPool;
    UnsafeShortArrayPool shortArrayPool;
    UnsafeCharArrayPool charArrayPool;
    UnsafeBooleanArrayPool booleanArrayPool;

    private Builder builder;

    public UnsafeArrayFactory(Builder builder)
    {
        this.builder = builder;

        poolFactory = ArrayPoolFactory.unsafe();

        if(builder.getIntMinLevelSize()>0)
            intArrayPool = (UnsafeIntArrayPool) poolFactory.createIntArrayPool(builder.getIntMinLevelSize(), builder.getIntMaxLevelSize(), builder.getIntDeamonRunner());

        if(builder.getLongMinLevelSize()>0)
            longArrayPool = (UnsafeLongArrayPool) poolFactory.createLongArrayPool(builder.getLongMinLevelSize(), builder.getLongMaxLevelSize(), builder.getLongDeamonRunner());

        if(builder.getShortMinLevelSize()>0)
            shortArrayPool = (UnsafeShortArrayPool) poolFactory.createShortArrayPool(builder.getShortMinLevelSize(), builder.getShortMaxLevelSize(), builder.getShortDeamonRunner());

        if(builder.getCharMinLevelSize()>0)
            charArrayPool = (UnsafeCharArrayPool) poolFactory.createCharArrayPool(builder.getCharMinLevelSize(), builder.getCharMaxLevelSize(), builder.getCharDeamonRunner());

        if(builder.getBooleanMinLevelSize()>0)
            booleanArrayPool = (UnsafeBooleanArrayPool) poolFactory.createBooleanArrayPool(builder.getBooleanMinLevelSize(), builder.getBooleanMaxLevelSize(), builder.getBooleanDeamonRunner());
    }

    @Override
    public IntArray createIntArray(int capacity) {
        return new UnsafePooledIntArray(intArrayPool, capacity);
    }

    @Override
    public IntArrayList createIntArrayList(int capacity) {
        return new UnsafePooledIntArrayList(intArrayPool, capacity);
    }

    @Override
    public LongArray createLongArray(int capacity) {
        return new UnsafePooledLongArray(longArrayPool, capacity);
    }

    @Override
    public LongArrayList createLongArrayList(int capacity) {
        return new UnsafePooledLongArrayList(longArrayPool, capacity);
    }

    @Override
    public BooleanArray createBooleanArray(int capacity) {
        return new UnsafePooledBooleanArray(booleanArrayPool, capacity);
    }

    @Override
    public BooleanArrayList createBooleanArrayList(int capacity) {
        return new UnsafePooledBooleanArrayList(booleanArrayPool, capacity);
    }

    @Override
    public ShortArray createShortArray(int capacity) {
        return new UnsafePooledShortArray(shortArrayPool, capacity);
    }

    @Override
    public ShortArrayList createShortArrayList(int capacity) {
        return new UnsafePooledShortArrayList(shortArrayPool, capacity);
    }

    @Override
    public CharArray createCharArray(int capacity) {
        return new UnsafePooledCharArray(charArrayPool, capacity);
    }

    @Override
    public CharArrayList createCharArrayList(int capacity) {
        return new UnsafePooledCharArrayList(charArrayPool, capacity);
    }

}
