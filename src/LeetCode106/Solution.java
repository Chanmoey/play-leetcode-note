package LeetCode106;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmory
 * @date 2021年11月21日 9:19
 * @description 通过中序遍历和后序遍历数组来构建一个二叉树。
 */
class Solution {

    private int index;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = inorder.length - 1;
        for (int i = 0; i <= index; i++) {
            map.put(inorder[i], i);
        }

        return this.insert(inorder, postorder, 0, this.index);
    }

    private TreeNode insert(int[] inorder, int[] postorder, int l, int r) {
        if (l > r) {
            return null;
        }

        int value = postorder[this.index--];
        TreeNode root = new TreeNode(value);

        int i = map.get(value);
        root.right = insert(inorder, postorder, i + 1, r);
        root.left = insert(inorder, postorder, l, i - 1);

        return root;
    }
}
