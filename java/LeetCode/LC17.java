package LeetCode;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author zhangqingyang
 * @date 2022-06-06-17:58
 */
public class LC17 {
    public static void main(String[] args) {
        String s = new String("23");
        Solution17 solution17 = new Solution17();
        List<String> list = solution17.letterCombinations(s);
        System.out.println(Arrays.toString(list.toArray()));
    }
}

class Solution17 {
    public HashMap<Character, String> map = new HashMap<>(8);

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        process(digits, 0, "", res);
        return res;
    }

    public void process(String digits, int index, String pre, List<String> res) {
        if (index >= digits.length()) {
            res.add(pre);
            return;
        }
        char num = digits.charAt(index);
        String letters = map.get(num);
        process(digits, index + 1, pre + letters.charAt(0), res);
        process(digits, index + 1, pre + letters.charAt(1), res);
        process(digits, index + 1, pre + letters.charAt(2), res);
        if (num == '7' || num == '9') {
            process(digits, index + 1, pre + letters.charAt(3), res);
        }
    }
}
