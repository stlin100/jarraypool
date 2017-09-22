package sunny.arraylist.common;

import sunny.arraylist.ArrayFactory;
import sunny.arraylist.DecimalArray;
import sunny.arraylist.LongArray;
import sunny.lang.Decimal;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/9/8.
 */
public class CommonDecimalArray implements DecimalArray {

    private int size;
    private LongArray array;

    Decimal decimalCursor;

    public CommonDecimalArray(ArrayFactory arrayFactory, int capacity) {

        this(arrayFactory.createLongArray(capacity * 2));
    }

    public CommonDecimalArray(LongArray array)
    {
        this.array = array;

        decimalCursor = new Decimal(array, 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void free() {
        array.free();
        array = null;
    }

    @Override
    public void append(BigDecimal value) {
        decimalCursor.setOffset(size * 2);
        decimalCursor.setValue(value);
        size++;
    }

    @Override
    public void append(int value) {
        decimalCursor.setOffset(size * 2);
        decimalCursor.setValue(value);
        size++;
    }

    @Override
    public void append(long value) {
        decimalCursor.setOffset(size * 2);
        decimalCursor.setValue(value);
        size++;
    }

    @Override
    public void set(int index, BigDecimal value) {
        if(index>=size)
        {
            size = index + 1;
        }

        decimalCursor.setOffset(index * 2);
        decimalCursor.setValue(value);
    }

    @Override
    public void set(int index, int value) {
        if(index>=size)
        {
            size = index + 1;
        }
        decimalCursor.setOffset(index * 2);
        decimalCursor.setValue(value);
    }

    @Override
    public void set(int index, long value) {
        if(index>=size)
        {
            size = index + 1;
        }
        decimalCursor.setOffset(index * 2);
        decimalCursor.setValue(value);
    }

    @Override
    public Decimal get(int index) {
        return new Decimal(array, index * 2);
    }

    @Override
    public BigDecimal getBigDecimal(int index) {
        decimalCursor.setOffset(index * 2);
        return decimalCursor.toBigDecimal();
    }
}
