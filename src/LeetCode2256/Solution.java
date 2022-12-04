package LeetCode2256;

/**
 * @author Chanmoey
 * @date 2022年12月04日
 */
class Solution {
    public int minimumAverageDifference(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        long[] preIdxSum = new long[nums.length];
        preIdxSum[0] = nums[0];
        long sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preIdxSum[i] = preIdxSum[i - 1] + nums[i];
            sum += nums[i];
        }


        long minAve = Long.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            long pre = preIdxSum[i];
            long late = sum - preIdxSum[i];

            long preAve = pre / (i + 1);
            long lateAve = late / (nums.length - i - 1);
            long aveDiff = Math.abs(preAve - lateAve);
            if (aveDiff < minAve) {
                minIdx = i;
                minAve = aveDiff;
            }
        }

        if (sum / nums.length < minAve) {
            minIdx = nums.length - 1;
        }

        return minIdx;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minimumAverageDifference(new int[]{5, 4, 3, 2, 1});
    }
}
