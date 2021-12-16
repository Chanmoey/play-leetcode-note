package LeetCode94;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            this.inorderTraversal(root.left, list);
            list.add(root.val);
            this.inorderTraversal(root.right, list);
        }
    }
}
