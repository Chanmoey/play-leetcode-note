package LeetCode98;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用二分搜索树的中序遍历的特性——元素按照 小->大 排序
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * */
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = this.dfs(root, list);
        return isSorted(list);
    }

    private List<Integer> dfs(TreeNode root, List<Integer> list) {

        if (root == null){
            return list;
        }

        this.dfs(root.left, list);
        list.add(root.val);
        this.dfs(root.right, list);

        return list;
    }

    private boolean isSorted(List<Integer> list) {
        int i = 0;
        while (i < list.size() - 1) {
            if (list.get(i) >= list.get(++i)){
                return false;
            }
        }
        return true;
    }
}
