package LeetCode334;

/**
 * @author Chanmoey
 * @date 2022年02月08日
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int greatMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= greatMin) {
                greatMin = num;
            } else if (num <= secondMin) {
                secondMin = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
