package LeetCode105;

import treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年02月18日
 */
class Solution {

    private final Queue<Integer> queue = new ArrayDeque<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int num : preorder) {
            this.queue.add(num);
        }
        return this.creatTree(inorder, 0, preorder.length - 1);
    }

    private TreeNode creatTree(int[] inorder, int lIdx, int rIdx) {
        if (lIdx > rIdx) {
            return null;
        }

        if (!this.queue.isEmpty() && this.isInScope(inorder, lIdx, rIdx, this.queue.peek())) {
            int value = this.queue.remove();
            TreeNode root = new TreeNode(value);
            int position = this.getIndex(inorder, value);
            root.left = creatTree(inorder, lIdx, position - 1);
            root.right = creatTree(inorder, position + 1, rIdx);
            return root;
        }

        return null;
    }

    private int getIndex(int[] arr, int e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return i;
            }
        }

        return -1;
    }

    private boolean isInScope(int[] arr, int start, int end, int e) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == e) {
                return true;
            }
        }

        return false;
    }
}
