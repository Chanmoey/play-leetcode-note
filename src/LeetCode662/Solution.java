package LeetCode662;

import treenode.TreeNode;

import java.util.*;

/**
 * BFS
 *
 * @author Chanmoey
 * @date 2022年02月27日
 */
class Solution {

    private static class Pair {
        public Pair(TreeNode key, int value) {
            this.key = key;
            this.value = value;
        }

        private final TreeNode key;
        private final int value;

    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> queue = new ArrayDeque<>();

        // 兼容Java 8
        queue.add(new Pair(root, 0));
        int maxWidth = 1;

        while (!queue.isEmpty()) {
            Pair head = queue.peek();
            Pair tail = head;

            for (int i = queue.size(); i > 0; i--) {
                tail = queue.poll();
                if (tail.key.left != null) {
                    queue.add(new Pair(tail.key.left, 2 * tail.value));
                }
                if (tail.key.right != null) {
                    queue.add(new Pair(tail.key.right, 2 * tail.value + 1));
                }
            }

            maxWidth = Math.max(maxWidth, tail.value - head.value + 1);
        }

        return maxWidth;
    }
}
