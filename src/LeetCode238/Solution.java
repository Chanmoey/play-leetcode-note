package LeetCode238;

/**
 * @author Chanmory
 * @date 2021年11月27日 15:46
 * @description Using the division operation.
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        long sum = 1L;
        int zeroCount = 0;
        for (int i : nums) {
            if (i == 0) {
                zeroCount++;
            } else {
                sum *= i;
            }
        }

        int[] res = new int[nums.length];
        if (zeroCount > 1) {
            return res;
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    res[i] = 0;
                } else {
                    res[i] = (int) sum;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                res[i] = (int) (sum / nums[i]);
            }
        }

        return res;
    }
}
