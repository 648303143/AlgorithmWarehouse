package binarytree;

import java.util.*;

/**
 * 二叉树每层最大结点数
 * @author zhangqingyang
 * @date 2022-05-31-15:15
 */
public class BinaryTreeMaxWidth {
    public int findMaxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int curNodeLevel = levelMap.get(curNode);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;

            }else {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 1;
                curLevel = curNodeLevel;
            }
            if (curNode.left != null) {
                levelMap.put(curNode.left, curNodeLevel + 1);
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                levelMap.put(curNode.right, curNodeLevel + 1);
                queue.add(curNode.right);
            }
        }
        return max;
    }
}
