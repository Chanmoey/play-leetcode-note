package LeetCode941;

/**
 * @author Chanmoey
 * @date 2022年01月25日
 */
class Solution {

    private static final int MOUNTAIN_MIN_LENGTH = 3;

    public boolean validMountainArray(int[] arr) {

        if (arr.length < MOUNTAIN_MIN_LENGTH) {
            return false;
        }

        int max = this.up(arr);
        if (max == arr.length - 1 || max == 0) {
            return false;
        }

        int end = this.down(max, arr);

        return end == arr.length - 1;
    }

    private int up(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return i;
            }
        }

        return arr.length - 1;
    }

    private int down(int start, int[] arr) {
        for (int i = start; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return i;
            }
        }

        return arr.length - 1;
    }
}
