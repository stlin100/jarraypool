package sunny.array.pool.a;

import java.util.HashMap;

/**
 * Created by lzx on 17/9/7.
 */
public class Log2N {

    private static HashMap<Integer,Integer> map = new HashMap<>();

    static
    {
        init();
    }

    private static void init()
    {
        for(int i=0;i<31;i++)
        {
            int key = 2<<i;
            map.put(key, i + 1);
        }
    }

    public static int log(int i)
    {
        Integer r = map.get(i);
        if(r==null)
            throw new IllegalArgumentException("log argument must be 2 pow.");
        return r;
    }
}
