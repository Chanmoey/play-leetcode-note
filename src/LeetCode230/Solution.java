package LeetCode230;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        this.BFS(root, list);
        return list.get(k - 1);
    }

    private void BFS(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        this.BFS(root.left, nums);
        nums.add(root.val);
        this.BFS(root.right, nums);
    }
}
