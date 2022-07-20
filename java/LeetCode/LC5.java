package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-20-17:13
 */
public class LC5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String longestPalindrome = solution5.longestPalindrome("cbbd");
        System.out.println(longestPalindrome);
    }
}


class Solution5 {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String palindrome1 = palindrome(s, i, i);
            String palindrome2 = palindrome(s, i, i + 1);
            longest = palindrome1.length() > longest.length() ? palindrome1 : longest;
            longest = palindrome2.length() > longest.length() ? palindrome2 : longest;

        }
        return longest;
    }

    public String palindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}
