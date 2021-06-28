package LeetCode376;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int wiggleMaxLength(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        List<Integer> array = this.deleteDuplicateElement(nums);

        if (array.size() <= 2) {
            return array.size();
        }

        int diff = array.get(1) - array.get(0), ret = 2;
        for (int i = 2; i < array.size(); i++) {
            if ((array.get(i) - array.get(i - 1)) * diff < 0) {
                ret++;
                diff = array.get(i) - array.get(i - 1);
            }
        }

        return ret;
    }

    private List<Integer> deleteDuplicateElement(int[] nums) {

        List<Integer> ret = new ArrayList<>();

        ret.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                ret.add(nums[i]);
            }
        }

        return ret;
    }
}
