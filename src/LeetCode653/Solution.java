package LeetCode653;

import treenode.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年02月03日
 */
class Solution {

    private final Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (set.contains(root.val)) {
            return true;
        }

        set.add(k - root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
