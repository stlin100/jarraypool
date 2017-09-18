package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeArrayPool;
import sunny.arraylist.CharArray;
import sunny.util.CharArrayCompares;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledUnsafeCharArray extends PooledUnsafeArray implements CharArray {

    private int size;

    public PooledUnsafeCharArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
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
        array.putChar(index * Character.BYTES, value);
    }

    @Override
    public void append(char value) {
        ensureCapacity(size);
        array.putChar(size * Character.BYTES, value);
        size++;
    }

    @Override
    public char get(int index) {
        return array.getChar(index * Character.BYTES);
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
