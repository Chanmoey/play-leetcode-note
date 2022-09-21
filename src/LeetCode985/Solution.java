package LeetCode985;

/**
 * Runtime: 21 ms, faster than 5.47% of Java online submissions for Sum of Even Numbers After Queries.
 *
 * @author Chanmoey
 * @date 2022年09月21日
 */
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            // 奇数
            if (Math.abs(val) % 2 == 1) {

                // 原来位置也是奇数，那么就会出现新的偶数
                if (Math.abs(nums[idx]) % 2 == 1) {
                    nums[idx] += val;
                    evenSum += nums[idx];
                } else { // 原数组的位置是偶数，那么原数组的位置就会变成奇数
                    evenSum -= nums[idx];
                    nums[idx] += val;
                }

            } else { // 偶数
                // 原数组的位置是奇数，那么原数组的位置就会变成奇数
                if (Math.abs(nums[idx]) % 2 == 1) {
                    nums[idx] += val;
                } else { // 原数组的位置是偶数，那么原数组的位置就会变成新的偶数
                    nums[idx] += val;
                    evenSum += val;
                }

            }
            res[i] = evenSum;
        }

        return res;
    }
}
