package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-21-10:33
 */
public class LC438 {
}


class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        ArrayList<Integer> res = new ArrayList<>(s.length());
        HashMap<Character, Integer> needs = new HashMap<>(p.length());
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) + 1);
            } else {
                needs.put(c, 1);
            }
        }
        HashMap<Character, Integer> window = new HashMap<>(p.length());
        int target = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
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


            while (right - left > p.length()) {
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    if (window.get(c2).equals(needs.get(c2))) {
                        target--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
                left++;
            }
            if (target == needs.size()) {
                res.add(left);
            }
        }
        return res;

    }
}
