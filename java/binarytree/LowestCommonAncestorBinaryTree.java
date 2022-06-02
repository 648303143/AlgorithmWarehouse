package binarytree;

import javafx.scene.transform.Rotate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 二叉树的最低公共祖先
 * @author zhangqingyang
 * @date 2022-06-01-16:18
 */
public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root,root);
        process(root, fatherMap);
        HashSet<TreeNode> set1 = new HashSet<>();
        TreeNode cur = p;
        while(cur != fatherMap.get(cur)){
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(root);
        cur = q;
        while (!set1.contains(cur)) {
            cur = fatherMap.get(cur);
        }
        return cur;
    }

    private void process(TreeNode root, HashMap<TreeNode, TreeNode> fatherMap) {
        if (root == null) {
            return;
        }
        fatherMap.put(root.left, root);
        fatherMap.put(root.right, root);
        process(root.left, fatherMap);
        process(root.right, fatherMap);
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;

    }
}
