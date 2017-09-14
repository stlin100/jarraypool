package sunny.arraypool.unsafe;

/**
 * Created by lzx on 17/9/6.
 */
public class UnsafeCharArrayLevelPool extends UnsafeArrayLevelPool {


    public UnsafeCharArrayLevelPool(int levelSize)
    {
        super(levelSize, Short.BYTES * levelSize);
    }


}
