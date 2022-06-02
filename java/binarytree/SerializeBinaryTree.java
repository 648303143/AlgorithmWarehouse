package binarytree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化二叉树
 * @author zhangqingyang
 * @date 2022-06-01-17:59
 */
public class SerializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String encode = root.val + "_";
        encode += serialize(root.left);
        encode += serialize(root.right);
        return encode;

    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] decodes = data.split("_");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, decodes);
        return decode(queue);
    }

    public TreeNode decode(Queue<String> queue) {
        String data = queue.poll();
        if ("#".equals(data)) {
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(data));
        cur.left = decode(queue);
        cur.right = decode(queue);
        return cur;
    }
}
