package LeetCode116;

/**
 * @author Chanmoey
 * @date 2021年12月29日
 */
class Solution1 {
    public Node connect(Node root) {
        if(root==null) {
            return null;
        }
        if(root.left!=null) {
            root.left.next=root.right;
        }
        if(root.right!=null&&root.next!=null) {
            root.right.next=root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
