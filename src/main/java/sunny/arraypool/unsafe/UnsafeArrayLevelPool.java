package sunny.arraypool.unsafe;

import sunny.arraypool.core.AbstractArrayLevelPool;
import sunny.arraypool.core.Element;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class UnsafeArrayLevelPool extends AbstractArrayLevelPool<UnsafeMemory> {

    public UnsafeArrayLevelPool(int levelSize, int heapBytes) {
        super(levelSize, heapBytes);
    }

    public UnsafeMemory create()
    {
        return new UnsafeMemory(heapBytes);
    }

    @Override
    public Element<UnsafeMemory> createElement(UnsafeMemory array) {
        return super.createElement(array);
    }
}
