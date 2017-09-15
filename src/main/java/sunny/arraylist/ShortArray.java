package sunny.arraylist;

/**
 * Created by lzx on 17/8/30.
 */
public interface ShortArray extends Array{
    void append(short value);
    void set(int index, short value);
    short get(int index);

    default void set(int index, int value)
    {
        set(index, (short)value);
    }

}
