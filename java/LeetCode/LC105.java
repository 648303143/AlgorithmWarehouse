package LeetCode;

import java.util.Scanner;

/**
 * @author zhangqingyang
 * @date 2022-07-26-17:43
 */
public class LC105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();

    }
}

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);
    }

    private TreeNode process(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = -1;
        for (int i = inLeft ; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        root.left = process(preorder, preLeft+1, preLeft + rootIndex, inorder, inLeft, rootIndex-1);
        root.right = process(preorder, preLeft + rootIndex+1, preRight, inorder, rootIndex+1, inRight);

        return root;
    }
}
