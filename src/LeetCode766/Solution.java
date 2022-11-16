package LeetCode766;

/**
 * @author Chanmoey
 * @date 2022年10月31日
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row --) {
            int itemRow = row;
            int col = 0;
            int start = matrix[itemRow][col];
            while (itemRow < matrix.length && col < matrix[0].length) {
                if (matrix[itemRow][col] != start) {
                    return false;
                }
                itemRow ++;
                col ++;
            }
        }

        for (int col = 1; col < matrix[0].length; col++) {
            int itemCol = col;
            int row = 0;
            int start = matrix[row][itemCol];
            while (row < matrix.length && itemCol < matrix[0].length) {
                if (matrix[row][itemCol] != start) {
                    return false;
                }
                row ++;
                itemCol ++;
            }
        }

        return true;
    }
}
