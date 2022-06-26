package LeetCode1423;

/**
 * @author Chanmoey
 * @date 2022年06月27日
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        int minSubarray = 0;

        int currSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
            currSum += cardPoints[i];
            if (i < n - k) minSubarray += cardPoints[i];
            else {
                currSum -= cardPoints[i - (n - k)];
                minSubarray = Math.min(minSubarray, currSum);
            }
        }

        return totalSum - minSubarray;
    }
}