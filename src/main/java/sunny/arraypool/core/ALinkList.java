package sunny.arraypool.core;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lzx on 17/9/7.
 */
public class ALinkList<T> implements LinkList<T> {

    private Element<T> header;
    private Element<T> tail;

    private ReentrantLock lock = new ReentrantLock();
    private ReentrantLock trimLock = new ReentrantLock();

    /*
    @Override
    public void push(T obj, int heapBytes) {
        push(new Element<>(obj, heapBytes));
    }
    */

    @Override
    public void push(Element<T> ele) {
        try
        {
            lock.lock();
            ele.next = header;
            header = ele;
            if (tail == null)
                tail = header;
        }finally
        {
            lock.unlock();
        }
    }

    @Override
    public Element<T> pop() {
        try {
            lock.lock();
            if (header == null)
                return null;

            Element<T> r = header;
            header = r.next;
            if(header!=null)
                header.prev = null;

            r.next = null;
            return r;
        }finally
        {
            lock.unlock();
        }
    }



    @Override
    public Element<T> header() {
        try {
            lock.lock();
            return header;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public Element<T> tail() {
        return tail;
    }


    @Override
    public void trimFrom(Element<T> ele) {
        try {
            trimLock.lock();
            tail = ele.prev;
            if (tail != null)
                tail.next = null;
        }finally
        {
            trimLock.unlock();
        }
    }
}
