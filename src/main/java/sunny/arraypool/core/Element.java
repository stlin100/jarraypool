package sunny.arraypool.core;

import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lzx on 17/9/6.
 */
public class Element<T> {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    WeakReference<T> ref;

    int heapSize;

    T obj;

    long lastTime;

    Element<T> prev;

    Element<T> next;

    boolean released;

    public Element(T obj, int heapSize)
    {
        this.obj = obj;
        this.heapSize = heapSize;
        HeapStats.incUsed(heapSize);

        this.lastTime = System.currentTimeMillis();
    }

    public boolean notnull()
    {
        T r = null;

        try {
            lock.readLock().lock();
            if (obj != null)
                r = obj;
            else if (ref != null) {
                r = ref.get();
                if (r == null && !released) {
                    release();
                }
            }
        }finally
        {
            lock.readLock().unlock();
        }
        return (r!=null);

    }

    public T get()
    {
        T r = obj;

        try {
            lock.readLock().lock();
            if (r != null)
                return r;
            else if (ref != null) {
                r = ref.get();
                if (r == null && !released) {
                    release();
                }
                return r;
            }
        }finally
        {
            lock.readLock().unlock();
        }
        return null;
    }

    public void weak()
    {
        T o = obj;
        if(o!=null)
        {
            lock.writeLock().lock();
            ref = new WeakReference<T>(o);
            obj = null;
            lock.writeLock().unlock();
        }
    }


    public void release()
    {
        lock.writeLock().lock();

        releaseObject();

        obj = null;
        if(ref!=null)
            ref.clear();
        HeapStats.decUsed(heapSize);
        released = true;
        lock.writeLock().unlock();
    }

    protected void releaseObject()
    {

    }
}
