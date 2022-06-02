package binarytree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 判断是搜索二叉树
 * 搜索二叉树 ： 中序遍历一定是升序
 * @author zhangqingyang
 * @date 2022-06-01-10:25
 */
public class BinarySearchTree {

    public int preValue = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftBST = isValidBST(root.left);
        if (!isLeftBST) {
            return false;
        }
        if (preValue >= root.val) {
            return false;
        }
        preValue = root.val;
        boolean isRightBST = isValidBST(root.right);
        return isRightBST;

    }


    public boolean isValidBSTIterate(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (preValue >= root.val) {
                return false;
            }else {
                preValue = root.val;
            }
            root = root.right;
        }
        return true;

    }
}
