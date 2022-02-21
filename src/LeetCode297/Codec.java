package LeetCode297;

import treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年02月21日
 */
public class Codec {

    private static final String NULL = "null";

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (sb.length() > 0) {
                sb.append(",");
            }

            if (node == null) {
                sb.append(NULL);
                continue;
            }

            sb.append(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.toString();
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (NULL.equals(nodes[0])) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        int i = 1;
        int n = nodes.length;
        queue.add(root);
        while (!queue.isEmpty() && i < n) {
            TreeNode node = queue.poll();
            TreeNode left = null;
            TreeNode right = null;

            if (!NULL.equals(nodes[i])) {
                left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(left);
            }

            i++;
            if (!NULL.equals(nodes[i])) {
                right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(right);
            }

            node.left = left;
            node.right = right;
            i++;
        }

        return root;
    }
}
