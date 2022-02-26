package LeetCode1523;

/**
 * @author Chanmoey
 * @date 2022年02月26日
 */
class Solution {
    public int countOdds(int low, int high) {

        int nums = high - low + 1;

        if (low % 2 != 0 && high % 2 != 0) {
            return nums / 2 + 1;
        } else {
            return nums / 2;
        }
    }
}
