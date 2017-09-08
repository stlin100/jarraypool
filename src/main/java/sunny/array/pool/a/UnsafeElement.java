package sunny.array.pool.a;

import sunny.array.pool.a.Element;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafeElement extends Element<UnsafeMemory> {

    public UnsafeElement(UnsafeMemory obj, int heapSize) {
        super(obj, heapSize);
    }

    @Override
    protected void releaseObject() {
        UnsafeMemory o = obj;
        if(o==null && ref!=null)
            o = ref.get();
        if(o!=null)
        {
            o.free();
        }
    }
}
