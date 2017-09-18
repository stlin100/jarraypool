package sunny.arraylist.unpooled;

import sunny.arraylist.*;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledUnsafeArrayFactory extends ArrayFactory {

    @Override
    public IntArray createIntArray(int capacity) {
        return new UnpooledUnsafeIntArray(capacity);
    }

    @Override
    public IntArrayList createIntArrayList(int capacity) {
        return new UnpooledUnsafeIntArrayList(capacity);
    }

    @Override
    public LongArray createLongArray(int capacity) {
        return new UnpooledUnsafeLongArray(capacity);
    }

    @Override
    public LongArrayList createLongArrayList(int capacity) {
        return new UnpooledUnsafeLongArrayList(capacity);
    }

    @Override
    public BooleanArray createBooleanArray(int capacity) {
        return new UnpooledUnsafeBooleanArray(capacity);
    }

    @Override
    public BooleanArrayList createBooleanArrayList(int capacity) {
        return new UnpooledUnsafeBooleanArrayList(capacity);
    }

    @Override
    public ShortArray createShortArray(int capacity) {
        return new UnpooledUnsafeShortArray(capacity);
    }

    @Override
    public ShortArrayList createShortArrayList(int capacity) {
        return new UnpooledUnsafeShortArrayList(capacity);
    }

    @Override
    public CharArray createCharArray(int capacity) {
        return new UnpooledUnsafeCharArray(capacity);
    }

    @Override
    public CharArrayList createCharArrayList(int capacity) {
        return new UnpooledUnsafeCharArrayList(capacity);
    }
}
