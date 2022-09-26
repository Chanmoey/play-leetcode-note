package LeetCode990;

/**
 * @author Chanmoey
 * @date 2022年09月26日
 */
class Solution {

    /**
     * 并查集
     */
    public int find(int[] parent, int e) {
        if (parent[e] == e) {
            return e;
        }

        parent[e] = find(parent, parent[e]);
        return parent[e];
    }

    public void union(int[] parent, int x, int y) {
        int parent1 = find(parent, x);
        int parent2 = find(parent, y);

        parent[parent2] = parent1;
    }

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[126];

        for (int i = 0; i < 126; i++) {
            parent[i] = i;
        }

        for (String equ : equations) {
            char[] chars = equ.toCharArray();

            if (chars[1] == '=' && find(parent, chars[0]) != find(parent, chars[3])) {
                union(parent, chars[0], chars[3]);
            }

        }

        for (String equ : equations) {
            char[] chars = equ.toCharArray();

            if (chars[1] == '!' && find(parent, chars[0]) == find(parent, chars[3])) {
                return false;
            }

        }

        return true;
    }
}
