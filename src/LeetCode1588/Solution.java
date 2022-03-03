package LeetCode1588;

class Solution {

    private static final int ODD_STEP = 2;

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;

        for (int len = 1; len <= arr.length; len += ODD_STEP) {
            for (int idx = 0; idx < arr.length; idx++) {
                if (idx + len <= arr.length) {
                    sum += this.getSubSum(arr, idx, len);
                }
            }
        }

        return sum;
    }

    private int getSubSum(int[] arr, int start, int length) {
        int subSum = 0;

        if (start + length > arr.length) {
            return subSum;
        }

        for (int i = start; i < start + length; i++) {
            subSum += arr[i];
        }

        return subSum;
    }
}
