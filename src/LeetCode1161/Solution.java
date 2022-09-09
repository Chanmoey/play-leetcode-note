package LeetCode1161;

import treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年09月09日
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            ++level;
            int levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                levelSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (levelSum > max) {
                max = levelSum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}
