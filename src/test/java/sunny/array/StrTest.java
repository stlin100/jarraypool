package sunny.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by lzx on 17/9/1.
 */
public class StrTest {

    private int times = 10;
    private int strLength = 10;
    @Test
    public void testStr()
    {
        for(int i=0;i<times;i++)
        {
            String s = makeString();
            Str str = new Str(s);
            Assert.assertEquals(s.length(), str.length());
            String s2 = str.toString();
            Assert.assertEquals(s, s2);

            str.free();
        }
    }

    private String makeString() {

        char[] chars = new char[strLength];
        Random random = new Random();
        for(int i=0;i<chars.length;i++)
        {
            chars[i] = (char)(Short.MAX_VALUE +  random.nextInt(Short.MAX_VALUE));
        }
        System.out.println(chars);
        return new String(chars);
    }


}
