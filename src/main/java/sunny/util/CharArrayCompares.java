package sunny.util;

import sunny.arraylist.CharArray;

/**
 * Created by lzx on 17/9/18.
 */
public class CharArrayCompares {

    public static int compare(char[] chars1, int len1, char[] chars2, int len2)
    {
        int lim = Math.min(len1, len2);

        int k = 0;
        while (k < lim) {
            char c1 = chars1[k];
            char c2 = chars2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    public static int compare(CharArray chars1, int len1, char[] chars2, int len2)
    {
        int lim = Math.min(len1, len2);

        int k = 0;
        while (k < lim) {
            char c1 = chars1.get(k);
            char c2 = chars2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    public static int compare(char[] chars1, int len1, CharArray chars2, int len2)
    {
        int lim = Math.min(len1, len2);

        int k = 0;
        while (k < lim) {
            char c1 = chars1[k];
            char c2 = chars2.get(k);
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    public static int compare(CharArray chars1, int len1, CharArray chars2, int len2)
    {
        int lim = Math.min(len1, len2);

        int k = 0;
        while (k < lim) {
            char c1 = chars1.get(k);
            char c2 = chars2.get(k);
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
}
