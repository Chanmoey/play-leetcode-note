package LeetCode1971;

/**
 * 使用并查集解决该问题
 *
 * @author Chanmoey
 * @date 2022年12月19日
 */
public class Solution2 {

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.rank = new int[size];

            for (int i = 0; i < size; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        private int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }

            return parent[p];
        }

        public boolean isConnect(int p, int q) {
            return find(p) == find(q);
        }

        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            // 深度小的树指向深度大的树
            if (rank[pRoot] < rank[qRoot]) {
                // 深度小的指向深度高的，那么合并后，树的深度不会改变
                parent[pRoot] = qRoot;
            } else if (rank[qRoot] < rank[pRoot]){
                parent[qRoot] = pRoot;
            } else {
                parent[qRoot] = pRoot;
                rank[pRoot] += 1;
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.unionElements(edge[0], edge[1]);
        }
        return unionFind.isConnect(source, destination);
    }
}
