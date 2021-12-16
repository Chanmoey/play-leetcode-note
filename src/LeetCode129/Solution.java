package LeetCode129;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> allPath = this.allPath(root);
        int sum = 0;
        for (List<Integer> list : allPath) {
            int item = 0;
            for (Integer i : list) {
                item = item * 10 + i;
            }
            sum += item;
        }

        return sum;
    }

    private List<List<Integer>> allPath(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            List<Integer> item = new ArrayList<>();
            item.add(root.val);
            res.add(item);
            return res;
        }

        List<List<Integer>> lPath = this.allPath(root.left);
        for (List<Integer> list : lPath) {
            list.add(0, root.val);
            res.add(list);
        }

        List<List<Integer>> rPath = this.allPath(root.right);
        for (List<Integer> list : rPath){
            list.add(0, root.val);
            res.add(list);
        }
        return res;
    }
}
