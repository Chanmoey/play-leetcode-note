package LeetCode1572;

/**
 * @author Chanmoey
 * @date 2022年03月04日
 */
class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += mat[i][i];
            sum += mat[m - 1 - i][i];
        }

        return m % 2 == 0 ? sum : sum - mat[m / 2][m / 2];
    }
}
