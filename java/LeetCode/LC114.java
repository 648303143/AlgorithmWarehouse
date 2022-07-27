package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-26-17:04
 */
public class LC114 {
    public static void main(String[] args) {
        Solution114 solution114 = new Solution114();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        solution114.flatten(treeNode1);
    }
}


class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;

        root.left = null;
        root.right = leftTree;

        TreeNode n = root;
        while (n.right != null) {
            n = n.right;
        }
        n.right = rightTree;

    }
}
