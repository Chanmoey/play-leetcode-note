package LeetCode337;

import treenode.TreeNode;

class Solution {

    public int rob(TreeNode root) {
        int[] result = this.tryRob(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * Time Limit Exceeded
     */
    private int rob(TreeNode root, boolean include) {

        if (root == null) {
            return 0;
        }

        int res = rob(root.left, true) + rob(root.right, true);

        if (include) {
            res = Math.max(root.val + rob(root.left, false) + rob(root.right, false), res);
        }

        return res;
    }

    private int[] tryRob(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] resultL = tryRob(root.left);
        int[] resultR = tryRob(root.right);
        int[] res = new int[]{0, 0};

        res[0] = resultL[1] + resultR[1];
        res[1] = Math.max(res[0], root.val + resultL[0] + resultR[0]);

        return res;
    }
}
