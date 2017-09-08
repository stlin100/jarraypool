package sunny.arraylist.pooled;

import sunny.arraylist.ArrayFactory;
import sunny.arraylist.DecimalArrayList;
import sunny.arraylist.LongArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class PooledDecimalArrayList extends PooledDecimalArray implements DecimalArrayList {

    public PooledDecimalArrayList(ArrayFactory arrayFactory, int capacity) {
        this(arrayFactory.createLongArrayList(capacity * 2));

    }

    public PooledDecimalArrayList(LongArrayList array) {
        super(array);
    }

    /**
     * longArrayList will extend itself
     * @param index
     */
    @Override
    public void ensureCapacity(int index) {

    }
}
