package LeetCode1342;

/**
 * @author Chanmoey
 * @date 2022年05月27日
 */
class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            step ++;
        }

        return step;
    }
}
