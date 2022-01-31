package LeetCode102;

import treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 不用Pair
 *
 * @author Chanmoey
 * @date 2022年01月31日
 */
class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.removeFirst();
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }

                if (temp.right != null) {
                    queue.addLast(temp.right);
                }

                level.add(temp.val);
            }
            res.add(level);
        }

        return res;
    }
}
