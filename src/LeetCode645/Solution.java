package LeetCode645;

import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {

                // rep
                if (nums[i] == nums[i + 1]) {
                    res[0] = nums[i];
                }

                // mis
                if (res[1] == 0 && i + 1 != nums[i] && i + 1 != nums[i + 1]) {
                    res[1] = i + 1;
                }
            }

            // mis
            if (i == nums.length - 1 && i + 1 != nums[i]) {
                res[1] = i + 1;
            }
        }
        return res;

        // 1 2 3 2
        // 1 2 2 3

        // 2 3 4 4
        // 2 3 4 4

        // 3 2 3 4 6 5
        // 2 3 3 4 5 6

        // 1 5 3 2 2 7 6 4 8 9
        // 1 2 2 3 4 5 6 7 8 9
    }

    public static void main(String[] args) {
//        int[] nums = {1,5,3,2,2,7,6,4,8,9};
        int[] nums = {2, 2};
        Solution solution = new Solution();
        int[] res = solution.findErrorNums(nums);

        for (int i : res) {
            System.out.println(i);
        }
    }
}
