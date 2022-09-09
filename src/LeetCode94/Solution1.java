package LeetCode94;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution1 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}