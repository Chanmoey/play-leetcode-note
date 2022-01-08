package LeetCode310;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2021年12月16日 8:59
 * @description Time Limit Exceeded
 */
class Solution {

    private Map<Integer, Integer> rootAndHeight;
    private int n;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (edges == null || edges.length == 0) {
//            return List.of(0); Java 8 不兼容
            return Collections.singletonList(0);
        }

        if (edges.length == 1) {
            return new ArrayList<>(Arrays.asList(edges[0][0], edges[0][1]));
        }

        this.rootAndHeight = new HashMap<>(n);
        this.n = n;

        for (int i = 0; i < n; i++) {
            List<List<Integer>> tree = new ArrayList<>();
            tree.add(new ArrayList<>());
            tree.get(0).add(i);
            this.buildTree(tree, edges);
        }

        int min = n + 1;

        for (Integer key : this.rootAndHeight.keySet()) {
            if (this.rootAndHeight.get(key) < min) {
                min = this.rootAndHeight.get(key);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Integer key : this.rootAndHeight.keySet()) {
            if (this.rootAndHeight.get(key) == min) {
                res.add(key);
            }
        }

        return res;
    }

    private void buildTree(List<List<Integer>> tree, int[][] edges) {

        List<Integer> nums = this.buildArrayNotRoot(tree.get(0).get(0), this.n);
        for (int k = 0; k < nums.size(); k ++) {
            boolean isConnect = false;
            for (int i = 0; i < tree.size(); i++) {
                for (int j = 0; j < tree.get(i).size(); j++) {
                    if (this.isConnect(tree.get(i).get(j), nums.get(k), edges)) {
                        isConnect = true;
                        if (tree.size() <= i + 1) {
                            tree.add(new ArrayList<>());
                        }
                        tree.get(i + 1).add(nums.get(k));
                        break;
                    }
                }
            }

            if (!isConnect) {
                nums.add(nums.get(k));
            }
        }
        System.out.println(tree);
        this.rootAndHeight.put(tree.get(0).get(0), tree.size());
    }

    private boolean isConnect(int first, int second, int[][] edges) {
        for (int[] edge : edges) {
            if (edge[0] == first && edge[1] == second || edge[0] == second && edge[1] == first) {
                return true;
            }
        }

        return false;
    }

    private List<Integer> buildArrayNotRoot(int root, int length) {
        List<Integer> nums = new ArrayList<>(length - 1);
        for (int i = 0; i < length; i++) {
            if (i != root) {
                nums.add(i);
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(solution.findMinHeightTrees(n, edges));
    }

    private boolean isInList(List<Integer> list, int e) {
        for (Integer i : list) {
            if (i == e) {
                return true;
            }
        }

        return true;
    }
}
