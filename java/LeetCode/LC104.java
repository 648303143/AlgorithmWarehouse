package LeetCode;

/**
 * @author zhangqingyang02
 * @date 2022-04-25-20:13
 */
public class LC104 {
}

class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
