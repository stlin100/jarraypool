package sunny.arraylist.pooled;


import sunny.arraylist.ArrayFactory;
import sunny.arraylist.CharArray;
import sunny.arraylist.IntArray;
import sunny.arraylist.StrArray;
import sunny.lang.Str;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledStrArray implements StrArray {

    private int size;
    protected CharArray[] charArrays = null;
    private ArrayFactory arrayFactory;

    protected int capacity;
    protected IntArray lengthArray;

    private Str cursor = new Str(null, -1);


    public PooledStrArray(ArrayFactory arrayFactory, int capacity) {

        this(arrayFactory, capacity, arrayFactory.createIntArray(capacity));
    }

    protected PooledStrArray(ArrayFactory arrayFactory, int capacity, IntArray lengthArray) {
        charArrays = new CharArray[capacity];
        this.arrayFactory = arrayFactory;
        this.capacity = capacity;
        this.lengthArray = lengthArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void free() {
        for(CharArray charArray: charArrays)
            charArray.free();
    }

    @Override
    public void set(int index, String value) {
        if(size<index+1)
        {
            size = index + 1;
        }

        int len = value.length();
        lengthArray.set(index, len);
        int cap = ((len+1)>>1) << 1;
        charArrays[index] = arrayFactory.createCharArray(cap);

        for(int i=0;i<len;i++)
            charArrays[index].set(i, value.charAt(index));
    }

    @Override
    public void set(int index, Str value) {
        if(size<index+1)
        {
            size = index + 1;
        }

        int len = value.length();
        lengthArray.set(index, len);
        int cap = ((len+1)>>1) << 1;
        charArrays[index] = arrayFactory.createCharArray(cap);

        for(int i=0;i<len;i++)
            charArrays[index].set(i, value.charAt(index));
    }

    @Override
    public Str get(int index) {
        if(charArrays[index]==null)
            return null;
        int len = lengthArray.get(index);
        return new Str(charArrays[index], len);
    }

    @Override
    public String getString(int index) {
        if(charArrays[index]==null)
            return null;
        int len = lengthArray.get(index);
        cursor.setCharArray(charArrays[index]);
        cursor.setLength(len);
        return cursor.toString();
    }
}
