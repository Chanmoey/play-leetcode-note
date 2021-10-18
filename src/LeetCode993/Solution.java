package LeetCode993;

import TreeNode.TreeNode;

class Solution {

    class Message {
        int depth;
        TreeNode parent;

        public Message(int depth, TreeNode parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    private Message mx;
    private Message my;

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }

        if (root.val == x || root.val == y) {
            return false;
        }

        findDepthAndParent(root, x, y, 0, null);

        if (this.mx == null || this.my == null) {
            return false;
        }

        return this.mx.depth == this.my.depth && this.mx.parent.val != this.my.parent.val;
    }

    private void findDepthAndParent(TreeNode root, int x, int y,
                                    int depth, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            mx = new Message(depth, parent);
            return;
        }

        if (root.val == y) {
            my = new Message(depth, parent);
            return;
        }

        findDepthAndParent(root.left, x, y, depth + 1, root);
        findDepthAndParent(root.right, x, y, depth + 1, root);
    }
}
