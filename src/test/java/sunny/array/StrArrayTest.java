package sunny.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/**
 * Created by lzx on 17/9/1.
 */
public class StrArrayTest {

    private static int arraySize = 1024 * 10;
    private static int strLength = 1024 / 2 /2;


    private static String[] stringArray;

    @BeforeClass
    public static void makeStringArray() {
        String[] array = new String[arraySize];
        for(int i=0;i<arraySize;i++)
            array[i] = makeString();
        stringArray = array;
    }

    @Test
    public void testStrArray1()
    {
        StrArray array = new UnsafeStrArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            array.set(i, s);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Str str = array.get(i);
            Assert.assertEquals(s.length(), str.length());
            String s2 = str.toString();
            Assert.assertEquals(s, s2);

            str.free();
        }
    }

    @Test
    public void testStrArray2()
    {
        StrArray array = new UnsafeStrArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            array.set(i, s);
        }


        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Str str = array.get(i);
            Assert.assertEquals(s.length(), str.length());
            String s2 = str.toString();
            Assert.assertEquals(s, s2);

            str.free();
        }
    }

    @Test
    public void testStrAppendArray1()
    {
        StrAppendArray array = new UnsafeStrAppendArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            array.append(s);
        }

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Str str = array.get(i);
            Assert.assertEquals(s.length(), str.length());
            String s2 = str.toString();
            Assert.assertEquals(s, s2);

            str.free();
        }
    }

    @Test
    public void testStrAppendArray2()
    {
        StrAppendArray array = new UnsafeStrAppendArray(arraySize);

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            array.append(s);
        }

        for(int i=0;i<arraySize;i++)
        {
            String s = stringArray[i];
            Str str = array.get(i);
            Assert.assertEquals(s.length(), str.length());
            String s2 = str.toString();
            Assert.assertEquals(s, s2);

            str.free();
        }
    }

    private static String makeString() {

        char[] chars = new char[strLength];
        Random random = new Random();
        for(int i=0;i<chars.length;i++)
        {
            chars[i] = (char)(Short.MAX_VALUE +  random.nextInt(Short.MAX_VALUE));
        }
        //System.out.println(chars);
        return new String(chars);
    }


}
