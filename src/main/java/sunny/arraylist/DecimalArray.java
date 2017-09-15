package sunny.arraylist;

import sunny.lang.Decimal;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/9/8.
 */
public interface DecimalArray extends Array {
    void append(BigDecimal value);
    void append(int value);
    void append(long value);
    void set(int index, BigDecimal value);
    void set(int index, int value);
    void set(int index, long value);

    Decimal get(int index);

    BigDecimal getBigDecimal(int index);
}