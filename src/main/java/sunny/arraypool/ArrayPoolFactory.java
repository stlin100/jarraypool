package sunny.arraypool;

import sunny.arraypool.core.WeakDeamonRunner;
import sunny.arraypool.heap.HeapArrayPoolFactory;
import sunny.arraypool.unsafe.UnsafeArrayPoolFactory;

/**
 * Created by lzx on 17/9/8.
 */
public interface ArrayPoolFactory {

    <TArray> ArrayPool<TArray> createIntArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner);

    <TArray> ArrayPool<TArray> createLongArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner);

    <TArray> ArrayPool<TArray> createCharArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner);

    <TArray> ArrayPool<TArray> createShortArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner);

    <TArray> ArrayPool<TArray> createBooleanArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner);


    public static UnsafeArrayPoolFactory unsafe()
    {
        return new UnsafeArrayPoolFactory();
    }

    public static HeapArrayPoolFactory heap()
    {
        return new HeapArrayPoolFactory();
    }
}
