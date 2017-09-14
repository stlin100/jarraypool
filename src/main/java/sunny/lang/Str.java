package sunny.lang;


import sunny.arraylist.CharArray;
import sunny.arraylist.ShortArray;

/**
 * Created by lzx on 17/8/31.
 */
public class Str implements Comparable<Str>{

    public final static String EMPTYSTRING = new String("");
    public final static Str EMPTYSTR = new Str(null, 0);

    private int length;
    private CharArray array;

    public Str(CharArray array, String str)
    {
        this.array = array;
        length = str.length();
        init(str);
    }

    public Str(CharArray array, char[] chars)
    {
        this.array = array;
        length = chars.length;
        init(chars);
    }

    public Str(CharArray array, Str nstr) {
        this.array = array;
        length = nstr.length;

        init(nstr);
    }

    public Str(CharArray array, int length) {
        this.array = array;
        this.length = length;
    }

    public void setCharArray(CharArray array)
    {
        this.array = array;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private void init(char[] chars) {
        for(int i=0;i<length;i++)
            array.set(i, chars[i]);
    }

    private void init(String str) {
        for(int i=0;i<str.length();i++)
            array.set(i, str.charAt(i));
    }

    private void init(Str str) {
        for(int i=0;i<str.length();i++)
            array.set(i, str.charAt(i));
    }

    public char charAt(int index)
    {
        return (char)array.get(index);
    }

    public String toString()
    {
        if(length==0)
            return EMPTYSTRING;

        char[] chars = new char[length];
        for(int i=0;i<length;i++)
        {
            chars[i] = (char)array.get(i);
        }
        return new String(chars);
    }

    public char[] toCharArray()
    {
        char[] chars = new char[length];
        for(int i=0;i<length;i++)
        {
            chars[i] = (char)array.get(i);
        }
        return chars;
    }

    public int length()
    {
        return length;
    }

    @Override
    public int compareTo(Str o) {
        int len1 = length;
        int len2 = o.length;
        int lim = Math.min(len1, len2);

        char s1, s2;
        int k = 0;
        while(k<lim) {
            s1 = array.get(k);
            s2 = o.array.get(k);
            if(s1!=s2){
                return s1 - s2;
            }
            k++;
        }
        return len1 - len2;
    }

    public void free() {
        array.free();
    }
}
