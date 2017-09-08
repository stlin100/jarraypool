package sunny.array.pool.unsafe;

import sunny.array.pool.heap.HeapArrayLevelPool;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/6.
 */
public class UnsafeIntArrayLevelPool extends UnsafeArrayLevelPool {


    public UnsafeIntArrayLevelPool(int levelSize)
    {
        super(levelSize, Integer.BYTES * levelSize);
    }


}
