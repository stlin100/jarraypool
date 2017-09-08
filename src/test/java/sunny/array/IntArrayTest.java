package sunny.array;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by lzx on 17/8/30.
 */
public class IntArrayTest {

    PrimitiveIntArray parray;
    UnsafeIntArray uarray;
    int[] iarray;
    @Before
    public void before()
    {
        IntArray array = new PrimitiveIntArray(1024);
        array.free();
        array = new UnsafeIntArray(1024);
        array.free();

        parray = new PrimitiveIntArray(putCount);
        uarray = new UnsafeIntArray(putCount);
        iarray = new int[putCount];
    }

    private int putCount = 1024 * 32;

    @Test
    public void test0()
    {
        int[] array = new int[putCount];
        for(int i=0;i<putCount;i++)
        {
            assert i < putCount;
            array[i] = i;
        }
        for(int i=0;i<putCount;i++)
        {
            assert i < putCount;
            int v = array[i];
            if(i != v)
                throw new RuntimeException();
        }
    }

    @Test
    public void testArrayList()
    {
        ArrayList<Integer> array = new ArrayList(putCount);
        for(int i=0;i<putCount;i++)
        {
            assert i < putCount;
            array.add(i);
        }
        for(int i=0;i<putCount;i++)
        {
            assert i < putCount;
            int v = array.get(i);
            if(i != v)
                throw new RuntimeException();
        }
    }

    @Test
    public void testPrimitive0()
    {
        IntArray array = new PrimitiveIntArray(1024);
        testPut(array, putCount);
        testGet(array, putCount);
    }

    @Test
    public void testPrimitive1()
    {
        IntArray array = new PrimitiveIntArray(1024);
        testPut(array, putCount);
        testGet(array, putCount);
    }

    @Test
    public void testUnsafe()
    {
        IntArray array = uarray; //new UnsafeIntArray(putCount);
        testPut(array, putCount);
        testGet(array, putCount);
    }

    public void testPut(IntArray intArray, int size)
    {
        for(int i=0;i<size;i++)
            intArray.set(i, i);
    }

    public void testGet(IntArray intArray, int size)
    {
        for(int i=0;i<size;i++)
        {
            int v = intArray.get(i);
            if(i != v)
                throw new RuntimeException();
        }
    }

    /*
    public void testPut(PrimitiveIntArray intArray, int size)
    {
        for(int i=0;i<size;i++)
            intArray.set(i, i);
    }

    public void testGet(PrimitiveIntArray intArray, int size)
    {
        for(int i=0;i<size;i++)
        {
            int v = intArray.get(i);
            if(i != v)
                throw new RuntimeException();
        }
    }
    */

    public void testPut(UnsafeIntArray intArray, int size)
    {
        for(int i=0;i<size;i++)
            intArray.set(i, i);
    }

    public void testGet(UnsafeIntArray intArray, int size)
    {
        for(int i=0;i<size;i++)
        {
            int v = intArray.get(i);
            if(i != v)
                throw new RuntimeException();
        }
    }

    public void testPut(int[] intArray, int size)
    {
        for(int i=0;i<size;i++)
            intArray[i] = i;
    }

    public void testGet(int[] intArray, int size)
    {
        for(int i=0;i<size;i++)
        {
            int v = intArray[i];
            if(i != v)
                throw new RuntimeException();
        }
    }

    @Test
    public void testIntPutGet()
    {
        for(int i=0;i<1000;i++)
        {
            testPut(iarray, putCount);
            testGet(iarray, putCount);
        }
    }

    @Test
    public void testUnsafePutGet()
    {
        testPutGet(uarray, 1000);

    }

    @Test
    public void testPrimitivePutGet()
    {
        testPutGet(parray, 1000);

    }

    public void testPutGet(IntArray array, int count)
    {

        for(int i=0;i<count;i++)
        {
            testPut(array, putCount);
            testGet(array, putCount);
        }
    }

        /*
    public void testPutGet(PrimitiveIntArray array, int count)
    {

        for(int i=0;i<count;i++)
        {
            testPut(array, putCount);
            testGet(array, putCount);
        }
    }


    public void testPutGet(UnsafeIntArray array, int count)
    {

        for(int i=0;i<count;i++)
        {
            testPut(array, putCount);
            testGet(array, putCount);
        }
    }
    */
}