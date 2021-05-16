package LeetCode209;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1; // 求区间[r...l]的和
        int sum = 0;
        int len = nums.length + 1;

        while(l < nums.length){

            if(r + 1 < nums.length && sum < s){
                sum += nums[++r];
            }
            else {
                sum -= nums[l++];
            }

            if (sum >= s){
                len = Math.min(len, r-l+1);
            }

        }
        if(len == nums.length + 1)
            return 0;
        return len;
    }
}