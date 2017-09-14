package sunny.arraypool.core;

import sunny.arraypool.ArrayPool;

/**
 * Created by lzx on 17/9/7.
 */
public abstract class AbstractArrayPool<TARRAY> implements ArrayPool<TARRAY> {

    private int minLevelSize;
    private int maxLevelSize;

    private int minLevelIndex;
    private int maxLevelIndex;

    private AbstractArrayLevelPool<TARRAY>[] levels;

    public AbstractArrayPool(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
    {
        this.minLevelSize = minLevelSize;
        this.maxLevelSize = maxLevelSize;

        int l1 = Log2N.log(minLevelSize);
        int l2 = Log2N.log(maxLevelSize) + 1;
        assert l2 < 32;
        levels = new AbstractArrayLevelPool[l2];
        for(int i=l1;i<l2;i++)
        {
            levels[i] = createLevelPool(2<<(i-1));
            deamonRunner.addLinkList(levels[i].linkList);
        }
    }

    public abstract AbstractArrayLevelPool<TARRAY> createLevelPool(int levelSize);
    public abstract int arrayLength(TARRAY array);

    private AbstractArrayLevelPool<TARRAY> getLevelPool(int size)
    {
        assert size>=minLevelSize;
        assert size<=maxLevelSize;

        int i = Log2N.log(size);
        return levels[i];
    }

    @Override
    public TARRAY get(int size) {
        AbstractArrayLevelPool<TARRAY> level = getLevelPool(size);
        return level.get();
    }

    @Override
    public void recycle(TARRAY array) {
        AbstractArrayLevelPool level = getLevelPool(arrayLength(array));
        level.recycle(array);
    }


}
