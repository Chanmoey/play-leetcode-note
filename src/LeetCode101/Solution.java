package LeetCode101;

import TreeNode.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * 思路:记录一层的结点，然后判断每一层是否对称。
 * */

class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root.left == null && root.right == null) {
            return true;
        }

        List<List<Integer>> value = this.bfs(root);
        for (List<Integer> list : value) {
            if (!this.isSymmetric(list)) {
                return false;
            }
        }

        return true;
    }

    private List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair<>(root, 0));
        while (!q.isEmpty()) {
            TreeNode node = q.getFirst().getKey();
            Integer level = q.getFirst().getValue();
            q.removeFirst();
            if (res.size() == level) {
                res.add(new ArrayList<>());
            }
            if (node == null) {
                res.get(level).add(-101);
            } else {
                res.get(level).add(node.val);
            }
            if (node != null) {
                q.addLast(new Pair<>(node.left, level + 1));
                q.addLast(new Pair<>(node.right, level + 1));
            }
        }
        return res;
    }

    private boolean isSymmetric(List<Integer> list) {
        assert list.size() > 0;
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
