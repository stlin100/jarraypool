package sunny.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by lzx on 17/9/18.
 */
public class UnsafeUtil {

    public static final Unsafe UNSAFE;
    public static final int BYTE_ARRAY_OFFSET;

    private static Field stringValueField;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            int boo = UNSAFE.arrayBaseOffset(byte[].class);
            // It seems not all Unsafe implementations implement the following method.
            UNSAFE.copyMemory(new byte[1], boo, new byte[1], boo, 1);
            BYTE_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);

            stringValueField = String.class.getDeclaredField("value");
            stringValueField.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static char[] getNativeChars(String s)
    {
        try {
            return (char[])stringValueField.get(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
