package sunny.arraypool.heap;

import sunny.arraypool.core.AbstractArrayPool;
import sunny.arraypool.core.WeakDeamonRunner;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class HeapArrayPool<T> extends AbstractArrayPool<T> {

    public HeapArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner) {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public T extend(T array, int newSize) {
        T newArray = get(newSize);
        int size = arrayLength(array);
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
}
