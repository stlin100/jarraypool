package sunny.arraypool.unsafe;

/**
 * Created by lzx on 17/9/6.
 */
public class UnsafeIntArrayLevelPool extends UnsafeArrayLevelPool {


    public UnsafeIntArrayLevelPool(int levelSize)
    {
        super(levelSize, Integer.BYTES * levelSize);
    }


}
