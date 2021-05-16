package Leetcode283;

class Solution {
//    public void moveZeroes(int[] nums) {
//
//        int i, k, l, j = nums.length;
//
//        for (l = 0; l < nums.length; l++) {
//            for (i = 0; i < j; i++) {
//
//                if (nums[i] == 0) {
//                    for (k = i; k < j - 1; k++) {
//                        nums[k] = nums[k + 1];
//                    }
//                    nums[--j] = 0;
//                }
//            }
//        }
//    }

//    public void moveZeroes(int[] nums) {
//
//        int j = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] != 0){
//                nums[j++] = nums[i];
//            }
//        }
//
//        for(; j < nums.length; j++ ){
//            nums[j] = 0;
//        }
//    }

    public void moveZeroes(int[] nums) {

        int j = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (j != i) {
                    temp = nums[j];
                    nums[j++] = nums[i];
                    nums[i] = temp;
                }
                else{
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        Solution sol = new Solution();
        sol.moveZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}