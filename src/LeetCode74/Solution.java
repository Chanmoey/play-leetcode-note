package LeetCode74;

/**
 * @author Chanmoey
 * @date 2022年01月04日
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchInRow(matrix, target);
        if (row == -1) {
            return false;
        }
        return binarySearch(matrix[row], 0, matrix[row].length - 1, target);
    }

    private int binarySearchInRow(int[][] matrix, int target){
        for (int i = 0; i < matrix.length; i ++) {
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                return i;
            }

            if (matrix[i][0] > target) {
                return -1;
            }
        }

        return -1;
    }

    private boolean binarySearch(int[] row, int start, int end, int target){
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (row[mid] < target) {
                start = mid + 1;
            } else if (row[mid] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.searchMatrix(new int[][]{{1}, {3}}, 4);
    }
}
