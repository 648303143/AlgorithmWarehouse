package binarytree;

/**
 * 平衡二叉树
 * @author zhangqingyang
 * @date 2022-06-01-14:26
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBalancedProcess(root).isBalanced;
    }

    class Result {
        public boolean isBalanced;
        public int height;
        public Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public Result isBalancedProcess(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }
        Result leftResult = isBalancedProcess(root.left);
        Result rightResult = isBalancedProcess(root.right);

        boolean isBalanced = leftResult.isBalanced && rightResult.isBalanced && Math.abs(leftResult.height - rightResult.height) < 2;
        int height = Math.max(leftResult.height, rightResult.height) + 1;

        return new Result(isBalanced, height);
    }
}
