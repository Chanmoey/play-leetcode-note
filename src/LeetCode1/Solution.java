package LeetCode1;/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i ++){
            result[0] = i;

            int nextindex = isContains(nums, i + 1, nums.length - 1, target - nums[i]);
            if(nextindex >= 0){
                result[1] = nextindex;
                return result;
            }
        }

        return result;
    }

    private int isContains(int[] nums, int r, int l, int target){

        for(int i = r; i <= l; i++){

            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }
}*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int complement = target - nums[i];

            if(record.containsKey(complement)){
                return new int[]{i, record.get(complement)};
            }

            record.put(nums[i], i);
        }
        return new int[]{0, 0}; // 因为必须要返回一个数组，所以...
    }
}
