package LeetCode;

import java.util.HashMap;

/**
 * @author zhangqingyang
 * @date 2022-07-21-10:04
 */
public class LC567 {
    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        boolean b = solution567.checkInclusion("ab", "eidbaooo");
        System.out.println(b);
    }
}


class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> needs = new HashMap<>(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) + 1);
            } else {
                needs.put(c, 1);
            }
        }
        HashMap<Character, Integer> window = new HashMap<>(s1.length());
        int target = 0;

        while (right < s2.length()) {
            char c1 = s2.charAt(right);
            right++;

            if (needs.containsKey(c1)) {
                if (window.containsKey(c1)) {
                    window.put(c1, window.get(c1) + 1);
                } else {
                    window.put(c1, 1);
                }

                if (window.get(c1).equals(needs.get(c1))) {
                    target++;
                }
            }


            while (right - left > s1.length()) {
                char c2 = s2.charAt(left);
                if (needs.containsKey(c2)) {
                    if (window.get(c2).equals(needs.get(c2))) {
                        target--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
                left++;
            }
            if (target == needs.size()) {
                return true;
            }
        }
        return false;

    }
}
