package LeetCode16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        /*int res = nums[0] + nums[1] + nums[2];
        int abs = Math.abs(nums[0] + nums[1] + nums[2] - target);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j ++) {
                for (int k = j + 1; k < nums.length; k ++) {
                    int thisAbs = Math.abs(((nums[i] + nums[j] + nums[k]) - target));
                    if (thisAbs < abs){
                        res = nums[i] + nums[j] + nums[k];
                        abs = thisAbs;
                    }
                }
            }
        }

        return res;*/

        Arrays.sort(nums);
        int diff = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i ++){
            int l = i + 1, r = nums.length - 1;
            int t = target - nums[i];

            while (l < r) {
                if (nums[l] + nums[r] == t){
                    return nums[i] + nums[l] + nums[r];
                }else {
                    if (Math.abs(nums[l] + nums[r] - t) < diff) {
                        diff = Math.abs(nums[l] + nums[r] - t);
                        res = nums[i] + nums[l] + nums[r];
                    }

                    if (nums[l] + nums[r] < t){
                        l ++;
                    }else {
                        r --;
                    }
                }
            }
        }

        return res;

    }
}