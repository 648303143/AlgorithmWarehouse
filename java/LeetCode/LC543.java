package LeetCode; /**
 * @author zhangqingyang02
 * @date 2022-04-16-19:30
 */

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点
 */
public class LC543 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
//        LeetCode.TreeNode n3 = new LeetCode.TreeNode(3);
//        LeetCode.TreeNode n4 = new LeetCode.TreeNode(4);
//        LeetCode.TreeNode n5 = new LeetCode.TreeNode(5);
        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;

        Solution543 solution543 = new Solution543();
        System.out.println(solution543.diameterOfBinaryTree(n1));
    }
}


class Solution543 {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return diameter;
    }

    private int findDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        diameter = Math.max(this.diameter, leftDepth + rightDepth);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}