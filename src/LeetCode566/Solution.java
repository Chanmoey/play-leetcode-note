package LeetCode566;

/**
 * @author Chanmoey
 * @date 2022年01月24日
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;

        if (row * col != r * c) {
            return mat;
        }

        int[][] reshape = new int[r][c];
        int rIndex = 0;
        int cIndex = 0;
        for (int[] ints : mat) {
            for (int j = 0; j < col; j++) {
                if (cIndex >= c) {
                    rIndex++;
                    cIndex = 0;
                }
                reshape[rIndex][cIndex] = ints[j];
                cIndex++;
            }
        }

        return reshape;
    }
}
