package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-25-16:10
 */
public class LC28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
//        int i = solution28.strStr("hello", "ll");
        int i = solution28.strStr("mississippi", "isisp");
        System.out.println(i);
    }
}


class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int[] next = getNextArray(needle);

        int i = 0;
        int j = 0;

        char[] haystackStr = haystack.toCharArray();
        char[] needleStr = needle.toCharArray();

        while (j < needleStr.length && i < haystackStr.length) {
            if (haystackStr[i] == needleStr[j]) {
                i++;
                j++;
            }else if (j == 0) {
                i++;
            }else {
                j = next[j];
            }
        }

        return j >= needleStr.length ? i - j : -1;

    }


    public int[] getNextArray(String needStr) {
        if (needStr.length() == 1) {
            return new int[]{-1};
        }

        int[] next = new int[needStr.length()];
        char[] chars = needStr.toCharArray();
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int shadow = 0;

        while (i < chars.length) {
            if (chars[i-1] == chars[shadow]) {
                shadow++;
                next[i] = shadow;
                i++;
            } else if (shadow > 0) {
                shadow = next[shadow];
            } else {
                i++;
            }
        }
        return next;
    }
}
