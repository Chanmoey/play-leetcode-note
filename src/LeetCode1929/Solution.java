package LeetCode1929;

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] retList = new int[2 * n];

        for (int i = 0; i < n; i++) {
            retList[i] = nums[i];
            retList[i + n] = nums[i];
        }

        return retList;
    }
}
