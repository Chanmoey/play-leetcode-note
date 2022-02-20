package LeetCode173;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年02月20日
 */
class BSTIterator {

    private final List<Integer> list = new ArrayList<>();
    private int size;
    private int index;

    public BSTIterator(TreeNode root) {
        this.size = 0;
        this.index = 0;
        this.inorder(root);
    }

    public int next() {
        return this.list.get(index++);
    }

    public boolean hasNext() {
        return index < this.size;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        this.list.add(root.val);
        this.size++;
        inorder(root.right);
    }
}