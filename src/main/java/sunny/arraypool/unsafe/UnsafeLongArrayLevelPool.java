package sunny.arraypool.unsafe;

/**
 * Created by lzx on 17/9/6.
 */
public class UnsafeLongArrayLevelPool extends UnsafeArrayLevelPool {


    public UnsafeLongArrayLevelPool(int levelSize)
    {
        super(levelSize, Long.BYTES * levelSize);
    }


}
