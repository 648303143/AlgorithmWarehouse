package binarytree;

/**
 * @author zhangqingyang
 * @date 2022-06-01-17:05
 */
public class InorderSuccessorBinaryTree {
    public TreeNodeP inorderSuccessor(TreeNodeP root, TreeNodeP p) {
        if (root == null) {
            return null;
        }
        if (p.right != null) {
            TreeNodeP cur = p.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }else {
            TreeNodeP parent = p.parent;
            while (parent != null && parent.left != p) {
                p = parent;
                parent = p.parent;
            }
            return parent;
        }
    }


    class TreeNodeP {
        int val;
        TreeNodeP left;
        TreeNodeP right;
        TreeNodeP parent;

        public TreeNodeP() {
        }

        public TreeNodeP(int val) {
            this.val = val;
        }

        public TreeNodeP(int val, TreeNodeP left, TreeNodeP right, TreeNodeP parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
