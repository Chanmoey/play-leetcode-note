package LeetCode257;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> leftS = this.binaryTreePaths(root.left);
        for (String s : leftS) {
            res.add(root.val + "->" + s);
        }

        List<String> rightS = this.binaryTreePaths(root.right);
        for (String s : rightS) {
            res.add(root.val + "->" + s);
        }

        return res;
    }
}
