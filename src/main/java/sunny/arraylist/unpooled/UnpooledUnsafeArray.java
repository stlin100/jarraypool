package sunny.arraylist.unpooled;

import sunny.arraylist.metric.Metrics;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/18.
 */
public abstract class UnpooledUnsafeArray extends UnpooledArray{

    protected UnsafeMemory memory = null;

    UnpooledUnsafeArray(int bytes)
    {
        allocate(bytes);
    }

    protected void allocate(int bytes) {
        memory = new UnsafeMemory(bytes);
        Metrics.unpooledAllocUnsafeSize.inc(bytes);
    }

    protected void reallocate(int bytes)
    {
    	int old = memory.length();
        memory.reallocate(bytes);
        Metrics.unpooledAllocUnsafeSize.inc(bytes-old);
    }

    @Override
    public final void free() {
        int bytes = memory.length();
        memory.free();
        memory = null;
        Metrics.unpooledAllocUnsafeSize.dec(bytes);
    }
}
