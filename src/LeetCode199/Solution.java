package LeetCode199;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<List<Integer>> allVal = new ArrayList<>();
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.addLast(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            TreeNode node = queue.getFirst().getKey();
            int index = queue.getFirst().getValue();
            if (allVal.size() == index) {
                allVal.add(new ArrayList<>());
            }
            allVal.get(index).add(node.val);
            queue.removeFirst();

            if (node.left != null) {
                queue.addLast(new Pair<>(node.left, index + 1));
            }
            if (node.right != null) {
                queue.addLast(new Pair<>(node.right, index + 1));
            }
        }

        for (List<Integer> list : allVal) {
            res.add(list.get(list.size() - 1));
        }

        return res;
    }
}
