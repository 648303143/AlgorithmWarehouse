package LeetCode;

import java.util.HashMap;

/**
 * @author zhangqingyang
 * @date 2022-07-20-19:49
 */
public class LC76 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = solution76.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}

class Solution76 {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!needs.containsKey(c)) {
                needs.put(c, 1);
            }else {
                needs.put(c, needs.get(c) +1);
            }
        }

        int start = 0;
        int len = Integer.MAX_VALUE;
        int target = 0;

        while (right < s.length()) {
            char curToAdd = s.charAt(right);
            right++;

            if (needs.containsKey(curToAdd)) {
                if (!window.containsKey(curToAdd)) {
                    window.put(curToAdd, 1);
                }else {
                    window.put(curToAdd, window.get(curToAdd) +1);
                }
                if (window.get(curToAdd).equals(needs.get(curToAdd))) {
                    target++;
                }
            }

            while (target == needs.size()) {

                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char curToRemove = s.charAt(left);
                if (needs.containsKey(curToRemove)) {
                    window.put(curToRemove, window.get(curToRemove)-1);
                    if (window.get(curToRemove) < needs.get(curToRemove)) {
                        target--;
                    }
                }
                left++;
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
