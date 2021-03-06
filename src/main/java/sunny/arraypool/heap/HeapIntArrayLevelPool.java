package sunny.arraypool.heap;

/**
 * Created by lzx on 17/9/6.
 */
public class HeapIntArrayLevelPool extends HeapArrayLevelPool<int[]> {


    public HeapIntArrayLevelPool(int levelSize)
    {
        super(levelSize, Integer.BYTES * levelSize);
    }

    public int[] create()
    {
        return new int[levelSize];
    }
}
