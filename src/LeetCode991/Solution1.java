package LeetCode991;

/**
 * @author Chanmoey
 * @date 2022年03月23日
 */
class Solution1 {
    public int brokenCalc(int startValue, int target) {
        if (target <= startValue) {
            return startValue - target;
        }

        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        }

        return 1 + brokenCalc(startValue, target + 1);
    }
}
