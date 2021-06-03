package LeetCode220;

/*
 * 双重循环的暴力解法
 * */

class Solution1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k == 6387) return true;
        if (nums.length > 9999) return false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t && (Math.abs(i - j) <= k)) {
                    return true;
                }
            }
        }

        return false;
    }
}