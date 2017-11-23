# jarraypool

Java Array and ArrayList pool Factory, support unpooled heap, unpooled unsafe, heap pool, unsafe pool.

Array:  IntArray, LongArray, ShortArray, CharArray, BooleanArray, StrArray, DecimalArray

ArrayList:  IntArrayList, LongArrayList, ShortArrayList, CharArrayList, BooleanArrayList, StrArrayList, DecimalArrayList

public abstract class ArrayFactory {

    public abstract IntArray createIntArray(int capacity);
    public abstract IntArrayList createIntArrayList(int capacity);

    public abstract LongArray createLongArray(int capacity);
    public abstract LongArrayList createLongArrayList(int capacity);

    public abstract BooleanArray createBooleanArray(int capacity);
    public abstract BooleanArrayList createBooleanArrayList(int capacity);

    public abstract ShortArray createShortArray(int capacity);
    public abstract ShortArrayList createShortArrayList(int capacity);

    public abstract CharArray createCharArray(int capacity);
    public abstract CharArrayList createCharArrayList(int capacity);
    
    ...
    }
