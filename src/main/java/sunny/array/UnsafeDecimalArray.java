package sunny.array;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by lzx on 17/8/30.
 */
public class UnsafeDecimalArray implements DecimalArray {

    private Decimal[] elements = null;

    private int size;

    public UnsafeDecimalArray()
    {
        this(32);
    }

    public UnsafeDecimalArray(int initialCapacity)
    {
        elements = new Decimal[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, BigDecimal value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }
        if(value!=null)
            elements[index] = new Decimal(value);
    }
    
    public void set(int index, Decimal value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }
        if(value!=null)
            elements[index] = value;
    }

    @Override
    public void set(int index, int value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }
        elements[index] = new Decimal(value);
    }

    @Override
    public void set(int index, long value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }
        elements[index] = new Decimal(value);
    }

    private void ensureCapacity(int index) {
        if(index>elements.length - 1)
            elements = Arrays.copyOf(elements, elements.length + (elements.length>>1));
    }

    @Override
    public Decimal get(int index) {
        assert index < size;
        return elements[index];
    }

    @Override
    public BigDecimal getBigDecimal(int index) {
        assert index < size;
        if(elements[index] == null)
            return null;
        else
            return elements[index].toBigDecimal();
    }


    @Override
    public void free() {
        for(Decimal str: elements)
        {
            if(str!=null)
                str.free();
        }
        elements = null;
    }
}
