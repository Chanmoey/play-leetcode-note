package LeetCode107;

import TreeNode.TreeNode;

import java.util.*;

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.addLast(new Pair<>(root, 0));

        while (!deque.isEmpty()) {
            TreeNode node = deque.getFirst().getKey();
            int level = deque.getFirst().getValue();
            if (node.left != null) {
                deque.addLast(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                deque.addLast(new Pair<>(node.right, level + 1));
            }

            if (level == list.size()) {
                list.add(new ArrayList<>());
            }

            list.get(level).add(node.val);

            deque.removeFirst();
        }

        Collections.reverse(list);

        return list;
    }
}
