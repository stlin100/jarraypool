package sunny.arraylist.unpooled;

import sunny.arraylist.*;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledHeapArrayFactory extends ArrayFactory {

    @Override
    public IntArray createIntArray(int capacity) {
        return new UnpooledHeapIntArray(capacity);
    }

    @Override
    public IntArrayList createIntArrayList(int capacity) {
        return new UnpooledHeapIntArrayList(capacity);
    }

    @Override
    public LongArray createLongArray(int capacity) {
        return new UnpooledHeapLongArray(capacity);
    }

    @Override
    public LongArrayList createLongArrayList(int capacity) {
        return new UnpooledHeapLongArrayList(capacity);
    }

    @Override
    public BooleanArray createBooleanArray(int capacity) {
        return new UnpooledHeapBooleanArray(capacity);
    }

    @Override
    public BooleanArrayList createBooleanArrayList(int capacity) {
        return new UnpooledHeapBooleanArrayList(capacity);
    }

    @Override
    public ShortArray createShortArray(int capacity) {
        return new UnpooledHeapShortArray(capacity);
    }

    @Override
    public ShortArrayList createShortArrayList(int capacity) {
        return new UnpooledHeapShortArrayList(capacity);
    }

    @Override
    public CharArray createCharArray(int capacity) {
        return new UnpooledHeapCharArray(capacity);
    }

    @Override
    public CharArrayList createCharArrayList(int capacity) {
        return new UnpooledHeapCharArrayList(capacity);
    }
}
