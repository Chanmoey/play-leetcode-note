package LeetCode264;

/**
 * 错误，第一次做的时候，不是很清楚题目的意思。
 *
 * @author Chanmoey
 * @date 2022年02月13日
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;

        int index = 1;
        int number = 2;
        while (index < n) {
            if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
                res[index++] = number;
            }

            number++;
        }

        return res[n - 1];
    }
}
