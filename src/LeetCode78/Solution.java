package LeetCode78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        this.res.add(new LinkedList<>());
        for (int i = 1; i <= nums.length; i ++) {
            this.getSet(nums, i, 0, new LinkedList<>());
        }

        return this.res;
    }

    private void getSet(int[] nums, int k, int start, LinkedList<Integer> s) {

        if (s.size() == k) {
            this.res.add((List<Integer>)s.clone());
            return;
        }

        for (int i = start; i < nums.length - (k - s.size()) + 1; i++) {
            s.addLast(nums[i]);
            this.getSet(nums, k, i + 1, s);
            s.removeLast();
        }
    }
}

