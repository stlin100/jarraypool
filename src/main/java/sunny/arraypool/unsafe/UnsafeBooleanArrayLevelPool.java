package sunny.arraypool.unsafe;

/**
 * Created by lzx on 17/9/6.
 */
public class UnsafeBooleanArrayLevelPool extends UnsafeArrayLevelPool {


    public UnsafeBooleanArrayLevelPool(int levelSize)
    {
        super(levelSize, Byte.BYTES * levelSize);
    }


}
