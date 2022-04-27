/**
 * @author zhangqingyang02
 * @date 2022-04-25-19:47
 */
public class LC101 {
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isEquals(root.left, root.right);

    }

    public boolean isEquals(TreeNode left, TreeNode right){
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isEquals(left.left,right.right) && isEquals(left.right,right.left);
    }
}