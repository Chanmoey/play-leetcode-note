package LeetCode606;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年09月07日
 */
class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        String ret = String.valueOf(root.val);

        if ("".equals(left) && "".equals(right)) {
            return ret;
        } else {
            if ("".equals(left)) {
                left = "()";
            } else {
                left = "(" + left + ")";
            }

            if (!"".equals(right)) {
                right = "(" + right + ")";
            }
        }

        return ret + left + right;
    }
}
