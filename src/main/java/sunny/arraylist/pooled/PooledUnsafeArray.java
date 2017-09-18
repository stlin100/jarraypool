package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeArrayPool;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class PooledUnsafeArray extends PooledArray<UnsafeMemory> {
    public PooledUnsafeArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }
}
