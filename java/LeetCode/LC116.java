package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-26-16:46
 */
public class LC116 {
}

class Solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftestNode = root;

        while(leftestNode.left != null){
            Node head = leftestNode;

            while (head != null) {

                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftestNode = leftestNode.left;
        }
        return root;

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
