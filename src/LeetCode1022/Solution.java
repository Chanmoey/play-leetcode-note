package LeetCode1022;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年01月11日
 */
class Solution {

    private List<String> binarys = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        this.getAllPath(root, String.valueOf(root.val));
        int res = 0;
        for (String binary : binarys) {
            res += Integer.parseInt(binary, 2);
        }

        return res;
    }

    private void getAllPath(TreeNode root, String binary) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            this.binarys.add(String.copyValueOf((binary).toCharArray()));
            return;
        }

        if (root.left != null) {
            getAllPath(root.left, binary + root.left.val);
        }
        if (root.right != null) {
            getAllPath(root.right, binary + root.right.val);
        }
    }
}
