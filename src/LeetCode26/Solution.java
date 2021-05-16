package LeetCode26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = s.removeDuplicates(nums);
        for(int i = 0; i < len; i++){
            System.out.print(nums[i]);
            System.out.print("-");
        }
    }
}