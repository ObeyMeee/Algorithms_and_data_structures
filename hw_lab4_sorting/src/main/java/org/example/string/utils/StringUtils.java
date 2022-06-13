package org.example.string.utils;

public class StringUtils {

    private StringUtils(){

    }

    public static int linearSubstringSearching(String str, String substr){
        int j, k = -1;
        do {
            k++;
            j = 0;
            while (j < substr.length() && str.charAt(k + j) == substr.charAt(j)){
                j++;
            }
            if(j == substr.length()){
                return k;
            }
        }while (k < str.length() - substr.length());
        return -1;
    }

    public static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p[i] = k;
        }
        return p;
    }

    public static int RKSubstringSearching(String txt, String pat){
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int q = 101;
        int d = 256;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if (j == M)
                    return i;
            }

            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0)
                    t = (t + q);
            }
        }
        return -1;
    }

    public static int KMPSubstringSearching(String str, String substr){
        int m = substr.length();
        if (m == 0)
            return 0;
        int[] p = prefixFunction(substr);
        for (int i = 0, k = 0; i < str.length(); i++)
            for (; ; k = p[k - 1]) {
                if (substr.charAt(k) == str.charAt(i)) {
                    if (++k == m)
                        return i + 1 - m;
                    break;
                }
                if (k == 0)
                    break;
            }
        return -1;
    }

    public static int BMSubstringSearching(String str, String substr) {
        char[] text = str.toCharArray();
        char[] pattern = substr.toCharArray();
        return indexOf(text, pattern);
    }
    private static int indexOf(char[] text, char[] pattern) {
        if (pattern.length == 0)
            return 0;
        int charTable[] = makeCharTable(pattern);
        int offsetTable[] = makeOffsetTable(pattern);
        for (int i = pattern.length - 1, j; i < text.length;)
        {
            for (j = pattern.length - 1; pattern[j] == text[i]; --i, --j)
                if (j == 0)
                    return i;
            i += Math.max(offsetTable[pattern.length - 1 - j], charTable[text[i]]);
        }
        return -1;
    }
    private static int[] makeCharTable(char[] pattern) {
        final int ALPHABET_SIZE = 256;
        int[] table = new int[ALPHABET_SIZE];
        for (int i = 0; i < table.length; ++i)
            table[i] = pattern.length;
        for (int i = 0; i < pattern.length - 1; ++i)
            table[pattern[i]] = pattern.length - 1 - i;
        return table;
    }
    private static int[] makeOffsetTable(char[] pattern) {
        int[] table = new int[pattern.length];
        int lastPrefixPosition = pattern.length;
        for (int i = pattern.length - 1; i >= 0; --i)
        {
            if (isPrefix(pattern, i + 1))
                lastPrefixPosition = i + 1;
            table[pattern.length - 1 - i] = lastPrefixPosition - i + pattern.length - 1;
        }
        for (int i = 0; i < pattern.length - 1; ++i)
        {
            int slen = suffixLength(pattern, i);
            table[slen] = pattern.length - 1 - i + slen;
        }
        return table;
    }
    private static boolean isPrefix(char[] pattern, int p) {
        for (int i = p, j = 0; i < pattern.length; ++i, ++j)
            if (pattern[i] != pattern[j])
                return false;
        return true;
    }
    private static int suffixLength(char[] pattern, int p) {
        int len = 0;
        for (int i = p, j = pattern.length - 1; i >= 0 && pattern[i] == pattern[j]; --i, --j)
            len += 1;
        return len;
    }

}
