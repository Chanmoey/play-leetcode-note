package LeetCode1448;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年09月01日
 */
class Solution {
    private int res = 0;
    private List<Integer> routh;
    int max = Integer.MIN_VALUE;

    public int goodNodes(TreeNode root) {
        routh = new ArrayList<>();
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            this.res++;
            System.out.println(node.val);
            this.max = node.val;
        }

        this.routh.add(node.val);

        dfs(node.left);
        dfs(node.right);

        Integer rm = routh.remove(routh.size() - 1);
        if (rm.equals(max)) {
            if (!routh.isEmpty()) {
                max = routh.stream().max(Integer::compareTo).get();
            } else {
                max = Integer.MIN_VALUE;
            }
        }
    }
}
