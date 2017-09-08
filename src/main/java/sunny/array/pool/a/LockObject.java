package sunny.array.pool.a;

import java.util.concurrent.locks.Lock;

/**
 * Created by lzx on 17/9/7.
 */
public class LockObject implements AutoCloseable{

    private Lock lock;

    public LockObject(Lock lock)
    {
        this.lock = lock;
        lock.lock();
    }

    @Override
    public void close() throws Exception {
        lock.unlock();
    }
}
