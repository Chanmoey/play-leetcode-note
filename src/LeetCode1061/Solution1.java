package LeetCode1061;

/**
 * 使用并查集
 *
 * @author Chanmoey
 * @date 2023年01月14日
 */
class Solution1 {

    private static class UnionFind {
        int[] parent = new int[26];

        public UnionFind() {
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        private int find(int c) {
            if (parent[c] == c) {
                return c;
            }
            return find(parent[c]);
        }

        private void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa < pb) {
                parent[pb] = pa;
            } else {
                parent[pa] = pb;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        UnionFind uf = new UnionFind();

        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char) (uf.find((baseStr.charAt(i) - 'a')) + 'a'));
        }

        return sb.toString();
    }
}
