package LeetCode145;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            this.postorderTraversal(root.left, list);
            this.postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }
}
