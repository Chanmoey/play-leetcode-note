package LeetCode878;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
class Solution {

    /**
     * 在1000000000，40000，40000测试用例中，内存不够呢。
     *
     * @param n n
     * @param a a
     * @param b b
     * @return 结果
     */
    @Deprecated
    public int oldNthMagicalNumber(int n, int a, int b) {
        int[] magical = new int[n];
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int mod = (int) (Math.pow(10, 9) + 7);

        int index = 0;
        int minMultiplier = 1;
        int maxMultiplier = 1;

        for (int i = index; i < n; i++) {
            if (min * minMultiplier < max * maxMultiplier) {
                magical[index++] = (min * minMultiplier) % mod;
                minMultiplier++;

            } else if (min * minMultiplier == max * maxMultiplier) {
                magical[index++] = (min * minMultiplier) % mod;
                minMultiplier++;
                maxMultiplier++;

            } else {
                magical[index++] = (max * maxMultiplier) % mod;
                maxMultiplier++;
            }
        }

        return magical[n - 1];
    }

    public int nthMagicalNumber(int n, int a, int b) {

        long mod = (long) (Math.pow(10, 9) + 7);

        int lcm = a * b / this.gcd(a, b);
        long left = 2L, right = (long) Math.min(a, b) * (long) n;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (this.getRank(mid, a, b, lcm) >= (long) n) {
                right = mid;
            } else {
                left = mid + 1L;
            }
        }

        return (int) (left % mod);
    }

    private long getRank(long mid, int a, int b, int lcm) {
        long aRank = mid / (long) a;
        long bRank = mid / (long) b;
        long abRank = mid / (long) lcm;
        return aRank + bRank - abRank;
    }

    private int gcd(int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b % a == 0) {
            return a;
        }

        return gcd(b % a, a);
    }
}
