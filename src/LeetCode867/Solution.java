package LeetCode867;

/**
 * @author Chanmoey
 * @date 2022年06月02日
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] t = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                t[j][i] = matrix[i][j];
            }
        }

        return t;
    }
}
