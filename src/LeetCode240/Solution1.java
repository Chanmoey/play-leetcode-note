package LeetCode240;

/**
 * @author Chanmoey
 * @date 2022年02月07日
 */
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row < matrix.length && row >= 0 && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }

        return false;
    }
}
