package LeetCode652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2023年02月28日
 */
class Solution1 {

    HashMap<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();

        dfs(res, root);
        return res;
    }

    public String dfs(List<TreeNode> res, TreeNode root) {
        if (root == null)
            return "";
        String left = dfs(res, root.left);
        String right = dfs(res, root.right);
        int curRoot = root.val;

        String stringFormed = curRoot + "$" + left + "$" + right;
        if (map.getOrDefault(stringFormed, 0) == 1) {
            res.add(root);
        }
        map.put(stringFormed, map.getOrDefault(stringFormed, 0) + 1);
        return stringFormed;
    }
}
