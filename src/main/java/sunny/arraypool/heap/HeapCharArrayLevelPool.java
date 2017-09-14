package sunny.arraypool.heap;

/**
 * Created by lzx on 17/9/6.
 */
public class HeapCharArrayLevelPool extends HeapArrayLevelPool<char[]> {


    public HeapCharArrayLevelPool(int levelSize)
    {
        super(levelSize, Short.BYTES * levelSize);
    }

    public char[] create()
    {
        return new char[levelSize];
    }
}
