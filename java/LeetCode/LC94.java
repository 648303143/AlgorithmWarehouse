package LeetCode; /**
 * @author zhangqingyang02
 * @create 2022-04-01-19:17
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class LC94 {
}

class Solution94 {
    /**
     * 方式一 ： 递归
     */
//    public List<Integer> inorderTraversal(LeetCode.TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        putVal(root, res);
//        return res;
//
//    }
//
//    private void putVal(LeetCode.TreeNode root, List<Integer> res){
//        if (root == null){
//            return;
//        }
//        putVal(root.left, res);
//        res.add(root.val);
//        putVal(root.right, res);
//    }

    /**
     * 方式二 ： 迭代
     */
//    public List<Integer> inorderTraversal(LeetCode.TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        LinkedList<LeetCode.TreeNode> stack = new LinkedList<>();
//
//        while (root != null || !stack.isEmpty()){
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            res.add(root.val);
//            root = root.right;
//        }
//        return res;
//    }

    /**
     * 方式三 ： 马拉车
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur = null;
        while (root != null) {
            if (root.left != null) {
                cur = root.left;
                while (cur.right != null && cur.right != root) {
                    cur = cur.right;
                }
                if (cur.right == null) {
                    cur.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    cur.right = null;
                    root = root.right;

                }
            } else {
                res.add(root.val);
                root = root.right;
            }

        }
        return res;
    }
}

