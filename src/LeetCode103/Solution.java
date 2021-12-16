package LeetCode103;

import treenode.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        int index = 0;
        while (!cur.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> subRes = new ArrayList<>();

            for (TreeNode node : cur) {
                subRes.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }

            if (index % 2 == 1) {
                Collections.reverse(subRes);
            }

            res.add(subRes);
            cur = next;
            index++;
        }

        return res;
    }
}
