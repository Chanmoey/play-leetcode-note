package LeetCode1491;

/**
 * @author Chanmoey
 * @date 2022年02月26日
 */
class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int j : salary) {
            max = Math.max(max, j);
            min = Math.min(min, j);
            sum += j;
        }

        return (double) (sum - (max + min)) / (salary.length - 2);
    }
}
