package LeetCode923;

/**
 * @author Chanmoey
 * @date 2022年04月06日
 */
class Solution1 {
    public int threeSumMulti(int[] arr, int target) {
        int[] hashMap = new int[101];

        for (int num : arr) {
            hashMap[num]++;
        }
        int n = hashMap.length;

        long ans = 0, mod = 1000000007;
        for (int i = 0; i < n; i++) {
            if (hashMap[i] == 0) {
                continue;
            }
            for (int j = 0; j <= i; j++) {
                int k = target - i - j;
                if (k < j || k > i || hashMap[j] == 0 || hashMap[k] == 0) {
                    continue;
                }
                long x = hashMap[i], y = hashMap[k], z = hashMap[j];
                if (i == j && i == k && hashMap[i] > 2) {
                    ans += x * (y - 1) * (z - 2) / 6;
                } else if (j == k && i != k && hashMap[j] > 1) {
                    ans += x * y * (z - 1) / 2;
                } else if (k == i && j != k && hashMap[i] > 1) {
                    ans += x * (y - 1) * z / 2;
                } else if (i != k && k != j) {
                    ans += x * y * z;
                }
            }
        }
        return (int) (ans % mod);
    }
}
