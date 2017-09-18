package sunny.arraylist.pooled;

import sunny.arraypool.ArrayPool;
import sunny.arraylist.CharArray;
import sunny.util.CharArrayCompares;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledHeapCharArray extends PooledArray<char[]> implements CharArray {

    private int size;

    public PooledHeapCharArray(ArrayPool<char[]> pool, int capacity) {
        super(pool, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(char value) {
        ensureCapacity(size);
        array[size] = value;
        size++;
    }

    @Override
    public void set(int index, char value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }
        array[index] = value;
    }

    @Override
    public char get(int index) {
        return array[index];
    }

    @Override
    public int compareTo(CharArray another) {
        char[] chars2 = another.nativeChars();
        if(chars2!=null)
            return CharArrayCompares.compare(array, size, chars2, another.size());
        else
            return CharArrayCompares.compare(array, size, another, another.size());
    }

    @Override
    public char[] nativeChars() {
        return array;
    }
}
