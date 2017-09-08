package sunny.array;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lzx on 17/9/1.
 */
public class DecimalArrayTest {

    private static int arraySize = 1024 * 100;

    private static String[] stringArray;

    @BeforeClass
    public static void makeStringArray() {
        String[] array = new String[arraySize];
        for(int i=0;i<arraySize;i++)
            array[i] = makeString();
        stringArray = array;
    }

    static Random random = new Random();
    private static String makeString() {

        return "" + random.nextInt() + "." + Math.abs(random.nextInt());

    }

    @Test
    public void testDecimalArray1()
    {
        DecimalArray array = new UnsafeDecimalArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal d = new Decimal(s);
            array.set(i, d);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal dec = array.get(i);

            //String s2 = dec.toString();
            //Assert.assertEquals(s, s2);

            dec.free();
        }
    }

    @Test
    public void testDecimalArray2()
    {
        DecimalArray array = new UnsafeDecimalArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal d = new Decimal(s);
            array.set(i, d);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal dec = array.get(i);

            String s2 = dec.toString();
            Assert.assertEquals(s, s2);

            dec.free();
        }
    }

    @Test
    public void testDecimalArray3()
    {
        DecimalArray array = new UnsafeDecimalArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal d = new Decimal(s);
            array.set(i, d);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal dec = array.get(i);

            //String s2 = dec.toString();
            //Assert.assertEquals(s, s2);

            //dec.free();
        }
    }

    @Test
    public void testBigDecimalArray()
    {
        ArrayList<BigDecimal> array = new ArrayList<>(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            BigDecimal d = new BigDecimal(s);
            array.add(d);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            BigDecimal dec = array.get(i);

            String s2 = dec.toString();
            Assert.assertEquals(s, s2);

        }
    }

    @Test
    public void testBigDecimalArray2()
    {
        ArrayList<BigDecimal> array = new ArrayList<>(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            BigDecimal d = new BigDecimal(s);
            array.add(d);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            BigDecimal dec = array.get(i);

            String s2 = dec.toString();
            Assert.assertEquals(s, s2);

        }
    }

    @Test
    public void testBigDecimalArray3()
    {
        ArrayList<BigDecimal> array = new ArrayList<>(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            BigDecimal d = new BigDecimal(s);
            array.add(d);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            BigDecimal dec = array.get(i);

            //String s2 = dec.toString();
            /// Assert.assertEquals(s, s2);

        }
    }

    @Test
    public void testStrAppendArray1()
    {
        DecimalAppendArray array = new UnsafeDecimalAppendArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal d = new Decimal(s);
            array.append(d);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal dec = array.get(i);

            String s2 = dec.toString();
            Assert.assertEquals(s, s2);

            dec.free();
        }
    }

    @Test
    public void testStrAppendArray2()
    {
        DecimalAppendArray array = new UnsafeDecimalAppendArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal d = new Decimal(s);
            array.append(d);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Decimal dec = array.get(i);

            //String s2 = dec.toString();
            //Assert.assertEquals(s, s2);

            //dec.free();
        }
    }

}
