package sunny.array;

/**
 * Created by lzx on 17/8/31.
 */
public class UnsafeStrAppendArray implements StrAppendArray {

    private int size;
    private IntArray offsetArray;
    private ShortArray valueArray;

    private int writeOffset;
    public UnsafeStrAppendArray()
    {
        this(8);
    }

    public UnsafeStrAppendArray(int initCapacity)
    {
        offsetArray = new UnsafeIntArray(initCapacity);
        valueArray = new UnsafeShortArray(initCapacity * 8); //assume 8 chars per string

        offsetArray.set(0, 0);
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void free() {
        offsetArray.free();
        valueArray.free();
    }

    /**
     * TODO: OPTIMIZED batch insert
     * @param value
     */
    @Override
    public void append(String value) {
        int len = value.length();
        offsetArray.set(size + 1, writeOffset + len);
        for(int i=0;i<len;i++)
        {
            valueArray.set(writeOffset + i, (short)value.charAt(i));
        }
        writeOffset += len;
        size ++;

    }

    @Override
    public Str get(int index) {
        assert index < size;
        int offset = offsetArray.get(index);
        int length = offsetArray.get(index + 1) - offset;
        return new Str(valueArray, offset, length);
    }

    @Override
    public String getString(int index) {
        return get(index).toString();
    }
}
