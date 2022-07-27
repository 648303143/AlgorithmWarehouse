package LeetCode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhangqingyang
 * @date 2022-07-26-16:01
 */
public class LC316 {
    public static void main(String[] args) {
        Solution316 solution316 = new Solution316();
        String str = solution316.removeDuplicateLetters("bcabc");
        System.out.println(str);
    }
}

class Solution316 {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[256];
        for (char aChar : chars) {
            count[aChar]++;
        }

        boolean[] exist = new boolean[256];
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if (!exist[aChar]) {
                while (!stack.isEmpty() && stack.peek() > aChar && count[stack.peek()] > 0) {
                    exist[stack.pop()] = false;
                }
                stack.push(aChar);
                exist[aChar] = true;
            }
            count[aChar]--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
