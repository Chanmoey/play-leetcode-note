package LeetCode220;

import java.util.TreeSet;

/*
* 查找表解法
* */

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        Long longT = (long)t;

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            Long item = (long) nums[i];
            if (record.ceiling(item - longT) != null && record.ceiling(item - longT) <= item + longT) {
                return true;
            }

            record.add(item);

            if (record.size() == k + 1) {
                record.remove((long)nums[i - k]);
            }
        }

        return false;
    }
}