package sunny.array;

/**
 * Created by lzx on 17/8/31.
 */
public interface StrArray extends Array {
    void set(int index, String value);
    void set(int index, Str value);
    Str get(int index);
    String getString(int index);
}
