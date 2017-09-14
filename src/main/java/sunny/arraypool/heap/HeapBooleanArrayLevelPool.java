package sunny.arraypool.heap;

/**
 * Created by lzx on 17/9/6.
 */
public class HeapBooleanArrayLevelPool extends HeapArrayLevelPool<boolean[]> {


    public HeapBooleanArrayLevelPool(int levelSize)
    {
        super(levelSize, Byte.BYTES * levelSize);
    }

    public boolean[] create()
    {
        return new boolean[levelSize];
    }
}
