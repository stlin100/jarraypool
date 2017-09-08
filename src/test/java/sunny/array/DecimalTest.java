package sunny.array;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by lzx on 17/9/1.
 */
public class DecimalTest {

    private int times = 10;
    private int strLength = 10;

    Random random = new Random();


    @Test
    public void testDoubles()
    {
        testDouble("11112222.00099990000");
        testDouble(".000999911");
        testDouble("100000.");
        testDouble("0.0001000");
        testDouble("100000");
        testLong(10000);


    }

    @Test
    public void testCompare()
    {
        Decimal d1 = new Decimal("1.0024");
        Decimal d2 = new Decimal("1.0024000000000000");

        assert d1.compareTo(d2)==0;

        d1 = new Decimal("1.024");
        d2 = new Decimal("1.0024000000000000");
        assert d1.compareTo(d2) > 0;
    }

    public void testDouble(String d)
    {

        Decimal d1 = new Decimal(d);
        Decimal d2 = new Decimal(d);

        assert d1.compareTo(d2) == 0;

        BigDecimal b1 = d1.toBigDecimal();
        BigDecimal b2 = d2.toBigDecimal();

        assert b1.compareTo(b2) == 0;

        BigDecimal b3 = new BigDecimal(d);
        assert b1.compareTo(b3) == 0;
    }

    public void testLong(long d)
    {

        Decimal d1 = new Decimal(d);
        Decimal d2 = new Decimal(d);

        assert d1.compareTo(d2) == 0;

        BigDecimal b1 = d1.toBigDecimal();
        BigDecimal b2 = d2.toBigDecimal();

        assert d1.toBigDecimal().compareTo(d2.toBigDecimal()) == 0;

        assert d1.toBigDecimal().longValue() == d;
    }

    public void testString()
    {
        String d = makeString();
        Decimal d1 = new Decimal(d);
        Decimal d2 = new Decimal(d);

        assert d1.compareTo(d2) == 0;

        assert d1.toBigDecimal().compareTo(d2.toBigDecimal()) == 0;

        //assert d1.toString().equals(d);
    }
    private String makeString() {

        Random random = new Random();
        return "" + random.nextDouble();
    }

    private double makeDouble() {

        return random.nextDouble();
    }

}
