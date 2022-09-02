package LeetCode637;

import treenode.TreeNode;

import java.text.DecimalFormat;
import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> level = inorder(root);
        List<Double> resAvg = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.00000");
        for (List<Integer> l : level) {
            Double avg = getAvg(l);
            resAvg.add(Double.valueOf(df.format(avg)));
        }

        return resAvg;
    }

    public double getAvg(List<Integer> list) {
        double sum = 0;
        for (Integer i : list) {
            sum += i;
        }

        return sum / list.size();
    }

    private List<List<Integer>> inorder(TreeNode root) {
        Deque<Pair> queue = new ArrayDeque<>();
        List<List<Integer>> level = new ArrayList<>();

        queue.addLast(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair cur = queue.removeFirst();
            int l = cur.getLevel();
            TreeNode node = cur.getNode();

            // 按层收集元素
            if (level.size() <= l) {
                level.add(new ArrayList<>());
            }
            level.get(l).add(node.val);

            if (node.left != null) {
                queue.addLast(new Pair(l + 1, node.left));
            }

            if (node.right != null) {
                queue.addLast(new Pair(l + 1, node.right));
            }
        }

        return level;
    }

    private static class Pair {
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }

        public int getLevel() {
            return level;
        }

        public TreeNode getNode() {
            return node;
        }
    }
}
