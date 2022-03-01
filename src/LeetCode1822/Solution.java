package LeetCode1822;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年03月01日
 */
class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for (int num : nums) {
            product *= num;
            if (product == 0) {
                break;
            } else if (product > 0) {
                product = 1;
            } else {
                product = -1;
            }
        }

        return Integer.compare(product, 0);
    }
}
