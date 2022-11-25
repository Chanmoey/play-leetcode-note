package LeetCode907;

/**
 * 暴力破解: Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年11月25日
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int res = 0;
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                res = (res + min) % mod;
            }
        }
        return res;
    }
}
