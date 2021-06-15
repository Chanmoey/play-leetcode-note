package LeetCode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        this.used = new boolean[nums.length];
        Arrays.sort(nums);
        LinkedList<Integer> p = new LinkedList<>();
        this.getPermute(nums, 0, p);
        return this.res;
    }

    private void getPermute(int[] nums, int index, LinkedList<Integer> list) {

        if (index == nums.length) {
            this.res.add((List<Integer>) list.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!this.used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                list.addLast(nums[i]);
                this.used[i] = true;
                this.getPermute(nums, index + 1, list);
                list.removeLast();
                used[i] = false;
            }
        }
        // return;
    }
}
