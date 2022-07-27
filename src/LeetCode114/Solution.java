package LeetCode114;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年07月27日
 */
class Solution {

    private List<TreeNode> list = new ArrayList<>();
    private TreeNode root;

    public void flatten(TreeNode root) {
        this.root = root;
        if (root == null) {
            return;
        }

        preOrder(root);
        createLeftTree();
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root);
        preOrder(root.left);
        root.left = null;
        preOrder(root.right);
        root.right = null;
    }

    private void createLeftTree() {
        this.root = list.get(0);
        TreeNode point = root;
        for (int i = 1; i < list.size(); i++) {
            point.right = list.get(i);
            point = point.right;
        }
    }
}
