package sunny.array;

/**
 * Created by lzx on 17/8/30.
 */
public interface ShortArray extends Array{

    void set(int index, short value);
    short get(int index);

    default void set(int index ,short[] values)
    {
        for(int i=0;i<values.length;i++)
        {
            set(index+i, values[i]);
        }
    }

    default void set(int index ,char[] values)
    {
        for(int i=0;i<values.length;i++)
        {
            set(index+i, (short)values[i]);
        }
    }
}
