package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-22-16:05
 */
public class LC424 {
    public static void main(String[] args) {
        Solution424 solution424 = new Solution424();
        int str = solution424.characterReplacement("AABABBA", 1);
        System.out.println(str);
    }
}


class Solution424 {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxn = 0;
        int[] count = new int[26];

        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, count[s.charAt(right) - 'A']);

            while (right - left + 1 - maxn > k) {

                count[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right-left;
    }
}
