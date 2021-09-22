package LeetCode485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        boolean standUp = false;
        int length = 0;
        for (int num : nums) {
            if (num == 1) {
                if (!standUp) {
                    standUp = true;
                }
                length++;
                if (length > max) {
                    max = length;
                }
            }

            if (num == 0) {
                if (standUp) {
                    standUp = false;
                    length = 0;
                }
            }
        }

        return max;
    }
}