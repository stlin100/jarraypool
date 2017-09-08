package sunny.array;

import java.math.BigDecimal;

/**
 * Created by lzx on 17/8/31.
 */
public interface DecimalAppendArray extends Array {
    void append(BigDecimal value);
    void append(Decimal value);
    void append(int value);
    void append(long value);
    void append(String value);

    Decimal get(int index);
    BigDecimal getBigDecimal(int index);
}
