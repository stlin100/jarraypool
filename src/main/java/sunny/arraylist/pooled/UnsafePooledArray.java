package sunny.arraylist.pooled;

import sunny.arraypool.unsafe.UnsafeArrayPool;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class UnsafePooledArray extends PooledArray<UnsafeMemory> {
    public UnsafePooledArray(UnsafeArrayPool pool, int capacity) {
        super(pool, capacity);
    }
}
