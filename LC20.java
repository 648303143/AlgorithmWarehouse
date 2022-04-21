import java.util.LinkedList;

/**
 * @author zhangqingyang02
 * @date 2022-04-21-19:40
 */
public class LC20 {
}

class Solution20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            switch (cur){
                case '(' : stack.push(')'); break;
                case '[' : stack.push(']'); break;
                case '{' : stack.push('}'); break;
                default:
                    if (stack.isEmpty() || stack.pop() != cur){
                        return false;
                    }
                    break;
            }
        }
        return stack.size() == 0;
    }
}