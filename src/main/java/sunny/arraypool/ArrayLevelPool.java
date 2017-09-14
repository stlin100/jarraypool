package sunny.arraypool;

/**
 * Created by lzx on 17/9/6.
 */
public interface ArrayLevelPool<T> {

    public int levelSize();
    T get();
    public void recycle(T array);

    T create();
}
