package sunny.arraylist.unpooled;

import sunny.arraylist.metric.MetricSystem;
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
        MetricSystem.unpooledAllocUnsafeSize.inc(bytes);
    }

    protected void reallocate(int bytes)
    {
        memory.reallocate(bytes);
        int old = memory.length();
        MetricSystem.unpooledAllocUnsafeSize.inc(bytes-old);
    }

    @Override
    public final void free() {
        int bytes = memory.length();
        memory.free();
        memory = null;
        MetricSystem.unpooledAllocUnsafeSize.dec(bytes);
    }
}
