package LeetCode985;

/**
 * 使用位运算，提高效率。 Runtime: 5 ms, faster than 91.32% of Java online submissions for Sum of Even Numbers After Queries.
 *
 * @author Chanmoey
 * @date 2022年09月21日
 */
class Solution1 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                evenSum += num;
            }
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            // 原数组是偶数
            if ((nums[idx] & 1) == 0) {
                // 先减掉
                evenSum -= nums[idx];
            }

            // 加上query
            nums[idx] += val;

            // 如果加上query是偶数，则evenSum再加回新的
            if ((nums[idx] & 1) == 0) {
                evenSum += nums[idx];
            }
            res[i] = evenSum;
        }

        return res;
    }
}
