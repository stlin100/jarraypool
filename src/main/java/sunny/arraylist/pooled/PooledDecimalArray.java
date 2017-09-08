package sunny.arraylist.pooled;

import sunny.arraylist.*;
import sunny.lang.Decimal;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledDecimalArray implements DecimalArray {

    private int size;
    private LongArray array;

    Decimal decimalCursor;

    public PooledDecimalArray(ArrayFactory arrayFactory, int capacity) {

        this(arrayFactory.createLongArray(capacity * 2));
    }

    public PooledDecimalArray(LongArray array)
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
    }

    @Override
    public void set(int index, BigDecimal value) {
        if(size<index+1)
        {
            size = index + 1;
        }

        decimalCursor.setOffset(index * 2);
        decimalCursor.setValue(value);
    }

    @Override
    public void set(int index, int value) {
        if(size<index+1)
        {
            size = index + 1;
        }
        decimalCursor.setOffset(index * 2);
        decimalCursor.setValue(value);
    }

    @Override
    public void set(int index, long value) {
        if(size<index+1)
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
