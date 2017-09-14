package sunny.arraypool;

/**
 * Created by lzx on 17/9/7.
 */
public interface ArrayPool<TARRAY> {
    public TARRAY get(int size);
    public TARRAY extend(TARRAY array, int newSize);
    public void recycle(TARRAY array);
}
