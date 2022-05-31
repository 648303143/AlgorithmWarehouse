package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 遍历二叉树
 * @author zhangqingyang
 * @date 2022-05-31-10:44
 */
public class TraverseBinaryTree {
    /**
     * 在递归中有三部分会访问到本身的代码
     * 按照递归序每个结点会被访问到三次
     * 顺序就是123
     * 前中后序遍历只需要在三个位置加需要的操作
     */
    public void preorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        //1

        //1
        System.out.println(head.val);
        preorderTraversal(head.left);
        //2

        //2
        preorderTraversal(head.right);
        //3

        //3
    }

    public void inorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        inorderTraversal(head.left);
        System.out.println(head.val);
        inorderTraversal(head.right);
    }

    public void postorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        postorderTraversal(head.left);
        postorderTraversal(head.right);
        System.out.println(head.val);
    }



    public List<Integer> preorderTraversalIterate(TreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalIterate(TreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty() || head != null) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            res.add(head.val);
            head = head.right;
        }
        return res;
    }

    public List<Integer> postorderTraversalIterate(TreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> outStack = new LinkedList<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            outStack.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!outStack.isEmpty()) {
            res.add(outStack.pop().val);
        }
        return res;
    }
}
