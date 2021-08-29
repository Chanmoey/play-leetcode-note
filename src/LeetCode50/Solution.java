package LeetCode50;

class Solution {

    /**
     * 循环实现
     *
     * @param x 底数
     * @param n 幂数
     * @return x^n
     */
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        double res = 1.0;
        long positiveN = Math.abs((long)n);
        while (positiveN > 0) {
            if (positiveN % 2 == 1) {
                res *= x;
            }
            x *= x;
            positiveN /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }

        return res;
    }

    /**
     * 直接使用Java的API
     *
     * @param x 底数
     * @param n 幂
     * @return x^n
     */
    public double myPowByJavaApi(double x, int n) {
        return Math.pow(x, n);
    }

    /**
     * 递归实现
     *
     * @param x
     * @param n
     * @return
     */
    public double myPowDP(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        double t = myPowDP(x, n / 2);
        if (n % 2 == 0) {
            return t * t;
        } else if (n > 0) {
            return t * t * x;
        }
        return t * t / x;
    }
}