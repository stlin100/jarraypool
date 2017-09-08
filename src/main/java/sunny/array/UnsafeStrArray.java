package sunny.array;

import java.util.Arrays;

/**
 * Created by lzx on 17/8/30.
 */
public class UnsafeStrArray implements StrArray {

    private Str[] elements = null;

    private int size;

    public UnsafeStrArray()
    {
        this(64);
    }

    public UnsafeStrArray(int initialCapacity)
    {
        elements = new Str[initialCapacity];
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    public final void set(int index, String value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }
        elements[index] = new Str(value);

    }

    @Override
    public final void set(int index, Str value) {
        ensureCapacity(index);
        if(size<index+1)
        {
            size = index + 1;
        }
        elements[index] = value;
    }

    private final void ensureCapacity(int index) {
        if(index>elements.length - 1)
            elements = Arrays.copyOf(elements, elements.length + (elements.length>>1));
    }

    @Override
    public final Str get(int index) {
        assert index < size;
        return elements[index];
    }

    @Override
    public final String getString(int index) {
        assert index < size;
        Str str =  elements[index];
        if(str==null)
            return null;
        else
            return str.toString();
    }

    @Override
    public final void free() {
        for(Str str: elements)
        {
            if(str!=null)
                str.free();
        }
        elements = null;
    }
}
