package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhangqingyang
 * @date 2022-07-21-10:42
 */
public class LC3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int str = solution3.lengthOfLongestSubstring("abcabcbb");
        System.out.println(str);
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        HashSet<Character> window = new HashSet<>(s.length());

        int len = Integer.MIN_VALUE;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            right++;

            while (window.contains(c1)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(c1);
            len = Math.max(len, right-left);
        }
        return len;
    }
}
