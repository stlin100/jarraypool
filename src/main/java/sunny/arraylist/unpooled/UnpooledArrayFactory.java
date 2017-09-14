package sunny.arraylist.unpooled;

import sunny.arraylist.*;

/**
 * Created by lzx on 17/9/14.
 */
public class UnpooledArrayFactory extends ArrayFactory {

    @Override
    public IntArray createIntArray(int capacity) {
        return new UnpooledIntArray(capacity);
    }

    @Override
    public IntArrayList createIntArrayList(int capacity) {
        return new UnpooledIntArrayList(capacity);
    }

    @Override
    public LongArray createLongArray(int capacity) {
        return new UnpooledLongArray(capacity);
    }

    @Override
    public LongArrayList createLongArrayList(int capacity) {
        return new UnpooledLongArrayList(capacity);
    }

    @Override
    public BooleanArray createBooleanArray(int capacity) {
        return new UnpooledBooleanArray(capacity);
    }

    @Override
    public BooleanArrayList createBooleanArrayList(int capacity) {
        return new UnpooledBooleanArrayList(capacity);
    }

    @Override
    public ShortArray createShortArray(int capacity) {
        return new UnpooledShortArray(capacity);
    }

    @Override
    public ShortArrayList createShortArrayList(int capacity) {
        return new UnpooledShortArrayList(capacity);
    }

    @Override
    public CharArray createCharArray(int capacity) {
        return new UnpooledCharArray(capacity);
    }

    @Override
    public CharArrayList createCharArrayList(int capacity) {
        return new UnpooledCharArrayList(capacity);
    }
}
