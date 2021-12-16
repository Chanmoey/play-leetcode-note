package LeetCode113;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null && root.val == targetSum) {
            List<Integer> item = new ArrayList<>();
            item.add(root.val);
            res.add(item);
            return res;
        }

        List<List<Integer>> lPath = this.pathSum(root.left, targetSum - root.val);
        for (List<Integer> list : lPath) {
            list.add(0, root.val);
            res.add(list);
        }

        List<List<Integer>> rPath = this.pathSum(root.right, targetSum - root.val);
        for (List<Integer> list : rPath){
            list.add(0, root.val);
            res.add(list);
        }
        return res;
    }
}
