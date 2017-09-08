package sunny.array;

/**
 * Created by lzx on 17/8/31.
 */
public final class Str implements Comparable<Str>{

    private final int offset;
    private final int length;
    private final ShortArray array;

    private boolean reference;

    public Str(String str)
    {
        length = str.length();
        offset = 0;
        array = createShortArray(length);
        init(str);
    }

    public Str(char[] chars)
    {
        length = chars.length;
        offset = 0;
        array = createShortArray(length);
        init(chars);
    }

    public Str(Str nstr) {
        length = nstr.length;
        offset = 0;
        array = createShortArray(length);
        init(nstr);
    }

    public Str(ShortArray array, int offset, int length) {
        this.array = array;
        this.offset = offset;
        this.length = length;

        this.reference = true;
    }


    protected ShortArray createShortArray(int length) {
        return new UnsafeShortArray(length);
    }

    private void init(char[] chars) {
        for(int i=0;i<length;i++)
            array.set(i, (short)chars[i]);
    }

    private void init(String str) {
        for(int i=0;i<str.length();i++)
            array.set(i, (short)str.charAt(i));
    }

    private void init(Str str) {
        for(int i=0;i<str.length();i++)
            array.set(i, (short)str.charAt(i));
    }

    public char charAt(int index)
    {
        return (char)array.get(offset + index);
    }

    public String toString()
    {
        char[] chars = new char[length];
        for(int i=0;i<length;i++)
        {
            chars[i] = (char)array.get(offset + i);
        }
        return new String(chars);
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

        short s1, s2;
        int k = 0;
        while(k<lim) {
            s1 = array.get(offset + k);
            s2 = array.get(o.offset + k);
            if(s1!=s2){
                return s1 - s2;
            }
            k++;
        }
        return len1 - len2;
    }

    public Str copy()
    {
        return new Str(this);
    }

    public void free() {
        if(!reference)
            array.free();
    }
}
