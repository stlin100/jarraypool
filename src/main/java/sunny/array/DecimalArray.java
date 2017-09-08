package sunny.array;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/8/31.
 */
public interface DecimalArray extends Array {
    void set(int index, BigDecimal value);
    void set(int index, Decimal value);
    void set(int index, int value);
    void set(int index, long value);

    Decimal get(int index);
    BigDecimal getBigDecimal(int index);
}
