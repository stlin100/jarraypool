package sunny.arraylist.common;

import sunny.arraylist.ArrayFactory;
import sunny.arraylist.DecimalArrayList;
import sunny.arraylist.LongArrayList;

/**
 * Created by lzx on 17/9/8.
 */
public class CommonDecimalArrayList extends CommonDecimalArray implements DecimalArrayList {

    public CommonDecimalArrayList(ArrayFactory arrayFactory, int capacity) {
        this(arrayFactory.createLongArrayList(capacity * 2));

    }

    public CommonDecimalArrayList(LongArrayList array) {
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
