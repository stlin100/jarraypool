package sunny.arraylist;

/**
 * Created by lzx on 17/8/30.
 */
public interface CharArray extends Array{

    void append(char value);
    void set(int index, char value);
    char get(int index);

    default void set(int index, short value)
    {
        set(index, (char)value);
    }

    default void set(int index, int value)
    {
        set(index, (char)value);
    }

    int compareTo(CharArray another);
    char[] nativeChars();
}
