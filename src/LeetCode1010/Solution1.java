package LeetCode1010;

/**
 * 如果 i % 60 = x, j % 60 = y, 且(x + y) % 60 = 0, 则 (i + j) % 60 = 0.
 * 所以只需要找到 x, y 的个数，两两配对，就是得到两个之和可以整除 60 的数字对了。
 * 特别的，如果 i % 60 = 0, j % 60 = 30, 那么 i he j 就可以自己配对。
 *
 * @author Chanmoey
 * @date 2022年01月02日
 */
class Solution1 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] map = new int[60];
        for (int num : time) {
            map[num % 60]++;
        }

        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) {
                int freq = map[i];
                res += (freq - 1) * freq / 2;
            } else {
                res += map[i] * map[60 - i];
            }
        }

        return res;
    }
}
