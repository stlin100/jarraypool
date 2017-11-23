package sunny.arraylist.common;


import sunny.arraylist.ArrayFactory;
import sunny.arraylist.CharArray;
import sunny.arraylist.IntArray;
import sunny.arraylist.StrArray;
import sunny.lang.Str;
import sunny.util.Util;

/**
 * Created by lzx on 17/9/8.
 */
public class CommonStrArray implements StrArray {

    private int size;
    protected CharArray[] charArrays = null;
    private ArrayFactory arrayFactory;

    protected int capacity;
    protected IntArray lengthArray;

    private Str cursor = new Str(null, -1);


    public CommonStrArray(ArrayFactory arrayFactory, int capacity) {

        this(arrayFactory, capacity, arrayFactory.createIntArray(capacity));
    }

    protected CommonStrArray(ArrayFactory arrayFactory, int capacity, IntArray lengthArray) {
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
        lengthArray.free();
        for(int i=0;i<size;i++)
            charArrays[i].free();
    }

    @Override
    public void append(String value) {
        set(size, value);
    }

    @Override
    public void append(Str value) {
        set(size, value);
    }

    @Override
    public void set(int index, String value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }

        if(value==null)
        {
            if(charArrays[index]!=null)
            {
                charArrays[index].free();
                charArrays[index] = null;
            }
            return;
        }

        int len = value.length();
        lengthArray.set(index, len);

        if(len>0) {
            int cap = Util.twoPowSizeFor(len);
            charArrays[index] = arrayFactory.createCharArray(cap);

            for (int i = 0; i < len; i++)
                charArrays[index].set(i, value.charAt(i));
        }
    }

    @Override
    public void set(int index, Str value) {
        ensureCapacity(index);
        if(index>=size)
        {
            size = index + 1;
        }

        if(value==null)
        {
            if(charArrays[index]!=null)
                charArrays[index].free();
            return;
        }

        int len = value.length();
        lengthArray.set(index, len);

        if(len>0) {
            int cap = Util.twoPowSizeFor(len);
            charArrays[index] = arrayFactory.createCharArray(cap);

            for (int i = 0; i < len; i++)
                charArrays[index].set(i, value.charAt(i));
        }
    }

    protected void ensureCapacity(int index) {
    }

    @Override
    public Str get(int index) {
        if(charArrays[index]==null)
            return null;
        int len = lengthArray.get(index);
        if(len==0)
            return Str.EMPTYSTR;
        return new Str(charArrays[index], len);
    }

    @Override
    public String getString(int index) {
        if(charArrays[index]==null)
            return null;
        int len = lengthArray.get(index);
        if(len==0)
            return Str.EMPTYSTRING;

        cursor.setCharArray(charArrays[index]);
        cursor.setLength(len);
        return cursor.toString();
    }
}
