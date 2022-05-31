package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历二叉树
 * @author zhangqingyang
 * @date 2022-05-31-19:46
 */
public class LC102 {
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList();
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            int num = queue.size();
            for(int i = 0; i < num; i++){
                TreeNode curNode = queue.poll();
                level.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.add(level);

        }
        return res;
    }
}