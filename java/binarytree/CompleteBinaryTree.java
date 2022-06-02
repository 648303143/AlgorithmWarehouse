package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangqingyang
 * @date 2022-06-01-11:34
 */
public class CompleteBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean afterMustLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pop();
            //两种情况认为不是完全二叉树
            //1 当前结点有右孩子没有左孩子
            //2 在遇到第一个孩子不双全的结点之后，存在结点不是叶子结点
            if ((cur.left == null && cur.right != null) || (afterMustLeaf && !(cur.left == null && cur.right == null))) {
                return false;
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (cur.left == null || cur.right == null) {
                afterMustLeaf = true;
            }

        }
        return true;
    }
}
