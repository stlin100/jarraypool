package sunny.arraypool.core;

import sunny.arraypool.ArrayLevelPool;

/**
 * Created by lzx on 17/9/6.
 */
public abstract class AbstractArrayLevelPool<TARRAY> implements ArrayLevelPool<TARRAY> {

    protected final int levelSize;
    protected int heapBytes;

    LinkList<TARRAY> linkList;

    public AbstractArrayLevelPool(int levelSize, int heapBytes)
    {
        this.levelSize = levelSize;
        this.heapBytes = heapBytes;

        linkList = new ALinkList<>();
    }
    @Override
    public int levelSize() {
        return levelSize;
    }

    public abstract TARRAY create();

    public Element<TARRAY> createElement(TARRAY array)
    {
        return new Element<>(array, heapBytes);
    }

    private void incUsed()
    {
        HeapStats.incUsed(heapBytes);
    }

    private void decUsed()
    {
        HeapStats.decUsed(heapBytes);
    }

    @Override
    public TARRAY get() {
        TARRAY r = null;
        Element<TARRAY> ele = linkList.pop();
        if(ele==null)
        {
            return create();
        }
        else {

            r = ele.get();
            if (r != null)
            {
                decUsed();
                return r;
            }
            else {
                if(!ele.released) //weaked
                {
                    decUsed();
                }
                return create();
            }
        }
    }

    @Override
    public void recycle(TARRAY array) {
        incUsed();
        Element<TARRAY> ele = createElement(array);
        linkList.push(ele);
    }
}
