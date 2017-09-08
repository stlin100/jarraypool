package sunny.array.pool.unsafe;

import sunny.array.pool.a.AbstractArrayLevelPool;
import sunny.array.pool.a.AbstractArrayPool;
import sunny.array.pool.a.WeakDeamonRunner;
import sunny.unsafe.UnsafeMemory;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class UnsafeArrayPool extends AbstractArrayPool<UnsafeMemory>{

    UnsafeMemory memory;
    public UnsafeArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner) {
        super(minLevelSize, maxLevelSize, deamonRunner);
    }

    @Override
    public abstract UnsafeArrayLevelPool createLevelPool(int levelSize);


    @Override
    public int arrayLength(UnsafeMemory array) {
        return array.length();
    }

    @Override
    public UnsafeMemory extend(UnsafeMemory array, int newSize) {

        UnsafeMemory newArray = get(newSize);
        array.copy(0, newArray, 0, arrayLength(array));
        return newArray;
    }
}
