package LeetCode637;

import treenode.TreeNode;

import java.util.*;

class Solution1 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resAvg = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                sum += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            resAvg.add(sum / size);
        }

        return resAvg;
    }
}
