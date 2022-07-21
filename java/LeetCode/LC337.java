package LeetCode;

import java.util.HashMap;

/**
 * @author zhangqingyang
 * @date 2022-07-21-16:57
 */
public class LC337 {
}


class Solution337 {
    private HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)){
            return memo.get(root);
        }

        int robIt = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        int notRobIt = rob(root.left) + rob(root.right);

        int max = Math.max(robIt, notRobIt);
        memo.put(root, max);
        return max;
    }
}
