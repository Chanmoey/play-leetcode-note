package LeetCode169;

class Solution {
    public int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int major = nums[0];
        int fre = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                fre++;
            } else {
                fre--;
                if (fre == 0) {
                    major = nums[i];
                    fre++;
                }
            }
        }

        return major;
    }
}
