package LeetCode80;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int j = 0, cont = 1;
        // [0, j]已经排好序
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j] ){
                nums[++j] = nums[i];
                cont = 1;
            }
            else if(cont < 2){
                nums[++j] = nums[i];
                cont ++;
            }
        }

        return j+1;
    }
}