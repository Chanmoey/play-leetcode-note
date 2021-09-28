package LeetCode922;

class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int[] res = new int[nums.length];
        int j = 0, k = 1;
        for (int num : nums) {
            if ((num & 1) == 0) {
                assert j < nums.length;
                res[j] = num;
                j += 2;
            } else {
                assert k < nums.length;
                res[k] = num;
                k += 2;
            }
        }

        return res;
    }
}
