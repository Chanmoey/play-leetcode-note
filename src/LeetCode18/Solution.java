package LeetCode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        if (n < 4){
            return res;
        }

        Arrays.sort(nums);
    }
}
