package LeetCode652;

import java.util.*;

/**
 * 通过字符串记录一棵树，存到HashMap中，看看是否相等。
 *
 * @author Chanmoey
 * @date 2023年02月28日
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode other) {
            return other.val == this.val;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return val;
    }

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    private Map<String, TreeNode> map = new HashMap<>();
    private Map<String, TreeNode> set = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(set.values());
    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }

        String cur = String.valueOf(node.val);
        String left = dfs(node.left);
        cur = left + cur;
        String right = dfs(node.right);
        cur = cur + right;
        if (map.containsKey(cur)) {
            set.put(cur, node);
        } else {
            map.put(cur, node);
        }
        return cur;
    }
}
