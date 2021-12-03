package LeetCode152;

/**
 * @author Chanmoey
 * @date 2021年12月03日 9:52
 * @description
 */
class Solution {

//    public int maxProduct(int[] nums) {
//        int max = nums[0];
//        int i = 0;
//        while (i < nums.length - 1) {
//            int pre = nums[i];
//            max = Math.max(pre, max);
//            int itemSum;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] - nums[j - 1] == 1) {
//                    itemSum = pre * nums[j];
//                    max = Math.max(itemSum, max);
//                } else {
//                    i = j;
//                }
//            }
//        }
//
//        return max;
//    }

    public int maxProduct(int[] nums) {
        int minVal = nums[0];
        int maxVal = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = minVal;
                minVal = maxVal;
                maxVal = temp;
            }

            maxVal = Math.max(maxVal*nums[i], nums[i]);
            minVal = Math.min(minVal*nums[i], nums[i]);
            res = Math.max(maxVal, res);
        }

        return res;
    }
}
