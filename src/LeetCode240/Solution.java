package LeetCode240;

/**
 * 循环一遍暴力破解。
 *
 * @author Chanmoey
 * @date 2022年02月07日
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
            }
        }

        return false;
    }
}