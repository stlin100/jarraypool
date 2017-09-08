package sunny.array;

import sunny.memory.UnsafeOffHeapMemory;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/9/1.
 */
public class UnsafeDecimalAppendArray implements DecimalAppendArray {


    private int size;
    private IntArray offsetArray;
    private UnsafeOffHeapMemory memory;

    private int writeOffset;
    public UnsafeDecimalAppendArray()
    {
        this(8);
    }

    public UnsafeDecimalAppendArray(int initCapacity)
    {
        offsetArray = new UnsafeIntArray(initCapacity);
        memory = new UnsafeOffHeapMemory(initCapacity * 14); //assume 10 byte

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void free() {
        offsetArray.free();
        memory.free();
    }

    @Override
    public void append(BigDecimal value) {
        if(value == null)
            appendNull();
        else
            append(value.toString());
    }

    @Override
    public void append(Decimal value) {
        if(value==null)
            appendNull();
        else
            append(value.toString());
    }

    private void appendNull() {
        offsetArray.set(size++,-1);
    }

    @Override
    public void append(int value) {
        append((long)value);

    }

    @Override
    public void append(long value) {
        memory.putLong(writeOffset, value);
        memory.putByte(writeOffset + 8, (byte)0);

        writeOffset += 9;
    }

    public void append(String value)
    {
        offsetArray.set(size++, writeOffset);
        String[] parts = value.split("\\.");

        long longValue = 0;
        if(parts[0].length()>0)
            longValue = Long.parseLong(parts[0]);

        if(parts.length>1 && parts[1].length()>0)
        {
            String right = parts[1];
            int scale = right.length();
            if(scale>18)
            {
                scale = 18;
                right = right.substring(0, 18);
            }

            if(scale>0) {
                long scaleValue = Long.parseLong(right);
                if (scaleValue > 0) {
                    putMemory(longValue, (byte)scale, scaleValue);
                    return;
                } else {
                    scale = -scale;
                }
            }

            putMemory(longValue, (byte)scale);

        }
        else
        {
            append(longValue);
        }
    }

    private void putMemory(long longValue, byte scale)
    {
        ensureCapacity(9);

        memory.putLong(writeOffset + 0, longValue);
        memory.putByte(writeOffset + 8, scale);

        writeOffset += 9;
    }

    private void putMemory(long longValue, byte scale, long scaleValue)
    {
        ensureCapacity(17);

        memory.putLong(writeOffset + 0, longValue);
        memory.putByte(writeOffset + 8, scale);

        memory.putLong(writeOffset + 8 + 1, scaleValue);

        writeOffset += 17;
    }

    private void ensureCapacity(int need) {
        long length = memory.length();
        if(writeOffset + need > length)
        {
            long extend = Math.min(length >> 2, need);
            if(extend<64)
                extend = 64;

            memory.reallocate(length + extend);
        }
    }

    @Override
    public Decimal get(int index) {
        int offset = offsetArray.get(index);
        if(offset<0)
            return null;
        else
        {
            return new Decimal(memory, offset);
        }
    }

    @Override
    public BigDecimal getBigDecimal(int index) {
        Decimal d = get(index);
        if(d==null)
            return null;
        else
            return d.toBigDecimal();
    }
}
