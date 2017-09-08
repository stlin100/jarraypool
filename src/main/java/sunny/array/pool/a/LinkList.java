package sunny.array.pool.a;

/**
 * Created by lzx on 17/9/6.
 */
public interface LinkList<T> {

    //public void push(T obj, int heapSize);

    public void push(Element<T> ele);

    public Element<T> pop();

    public Element<T> header();

    public Element<T> tail();

    public void trimFrom(Element<T> ele);
}
