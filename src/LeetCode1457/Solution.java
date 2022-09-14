package LeetCode1457;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年09月14日
 */
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, new int[10]);
    }

    private int dfs(TreeNode node, int[] freq) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            freq[node.val]++;
            return isPseudoPalindromic(freq) ? 1 : 0;
        } else {
            freq[node.val]++;
            return dfs(node.left, deepCopy(freq)) + dfs(node.right, deepCopy(freq));
        }
    }

    private int[] deepCopy(int[] arr) {
        int[] copy = new int[10];
        System.arraycopy(arr, 0, copy, 0, 10);
        return copy;
    }

    private boolean isPseudoPalindromic(int[] arr) {
        int oddCount = 0;
        for (int k : arr) {
            oddCount += k % 2 == 1 ? 1 : 0;
        }
        return oddCount < 2;
    }
}
