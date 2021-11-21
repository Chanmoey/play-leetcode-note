package LeetCode540;

/**
 * @author Chanmory
 * @date 2021年11月20日 9:17
 * @description
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int res = 0;
        for (int n : nums) {
            res ^= n;
        }

        return res;
    }
}
