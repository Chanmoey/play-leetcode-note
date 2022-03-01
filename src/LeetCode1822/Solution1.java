package LeetCode1822;

/**
 * @author Chanmoey
 * @date 2022年03月01日
 */
class Solution1 {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num < 0) {
                if (sign == 1) {
                    sign = -1;
                } else {
                    sign = 1;
                }
            } else if (num == 0) {
                sign = 0;
                break;
            }
        }

        return sign;
    }
}
