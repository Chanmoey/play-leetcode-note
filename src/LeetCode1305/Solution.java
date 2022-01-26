package LeetCode1305;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年01月26日
 */
class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        this.inorderTraversal(root1, list1);
        this.inorderTraversal(root2, list2);

        return this.merge(list1, list2);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>(list1.size() + list2.size());

        // 从小到大归并两个list
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                list.add(list1.get(i));
                i++;
            } else {
                list.add(list2.get(j));
                j++;
            }
        }

        // 当list1没有完全归并完，就将剩下的都放到list末尾。
        while (i < list1.size()) {
            list.add(list1.get(i));
            i++;
        }

        // 当list2没有完全归并完，就将剩下的都放到list末尾。
        while (j < list2.size()) {
            list.add(list2.get(j));
            j++;
        }

        return list;
    }
}
