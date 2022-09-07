package LeetCode606;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年09月07日
 */
public class Solution1 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {

        sb.append(root.val);

        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            sb.append("(");
            preorder(root.left, sb);
            sb.append(")");
        } else {
            sb.append("()");
        }

        if (root.right != null) {
            sb.append("(");
            preorder(root.right, sb);
            sb.append(")");
        }
    }
}
