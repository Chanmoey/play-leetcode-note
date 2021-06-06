package LeetCode144;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            this.preorderTraversal(root.left, list);
            this.preorderTraversal(root.right, list);
        }
    }
}