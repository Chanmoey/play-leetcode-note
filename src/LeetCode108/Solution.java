package LeetCode108;

import treenode.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return this.sortedArrayToBST(nums, 0, nums.length - 1);
    }

    // [begin, end]
    private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (end < begin) {
            return null;
        }
        int index = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = this.sortedArrayToBST(nums, begin, index - 1);
        root.right = this.sortedArrayToBST(nums, index + 1, end);
        return root;
    }

    /**
     * 测试使用
     * private void BFS(TreeNode root) {
     *         if (root == null) {
     *             return;
     *         }
     *
     *         this.BFS(root.left);
     *         System.out.print(root.val + "->");
     *         this.BFS(root.right);
     *     }
     *
     *     public static void main(String[] args) {
     *         int[] nums = {-10,-3,0,5,9};
     *         Solution s = new Solution();
     *         TreeNode root = s.sortedArrayToBST(nums);
     *         s.BFS(root);
     *     }
     * */
}
