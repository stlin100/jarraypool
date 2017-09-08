package sunny.array.pool.unsafe;

/**
 * Created by lzx on 17/9/6.
 */
public class UnsafeShortArrayLevelPool extends UnsafeArrayLevelPool {


    public UnsafeShortArrayLevelPool(int levelSize)
    {
        super(levelSize, Short.BYTES * levelSize);
    }


}
