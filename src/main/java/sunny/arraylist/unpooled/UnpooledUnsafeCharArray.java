package sunny.arraylist.unpooled;

import sunny.arraylist.CharArray;
import sunny.unsafe.UnsafeMemory;
import sunny.util.CharArrayCompares;

/**
 * Created by lzx on 17/9/18.
 */
public class UnpooledUnsafeCharArray extends UnpooledUnsafeArray implements CharArray {
    protected int capacity;

    private int size;

    public UnpooledUnsafeCharArray(int initialCapacity)
    {
        super(Character.BYTES * initialCapacity);
        capacity = initialCapacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, char value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        memory.putChar(index * Character.BYTES, value);
    }

    @Override
    public void append(char value) {
        ensureCapacity(size);
        memory.putChar(size * Character.BYTES, value);
        size++;
    }

    @Override
    public char get(int index) {
        return memory.getChar(index * Character.BYTES);
    }

    @Override
    public int compareTo(CharArray another) {
        char[] chars2 = another.nativeChars();
        if(chars2!=null)
            return CharArrayCompares.compare(this, size, chars2, another.size());
        else
            return CharArrayCompares.compare(this, size, another, another.size());
    }

    @Override
    public char[] nativeChars() {
        return null;
    }

}
