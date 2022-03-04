package LeetCode799;

/**
 * @author Chanmoey
 * @date 2022年03月04日
 */
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] res = new double[101][101];
        res[0][0] = poured;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                if (res[i][j] >= 1) {
                    res[i + 1][j] += (res[i][j] - 1) / 2.0;
                    res[i + 1][j + 1] += (res[i][j] - 1) / 2.0;
                    res[i][j] = 1;
                }
            }
        }

        return res[query_row][query_glass];
    }
}
