package LeetCode39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        LinkedList<Integer> c = new LinkedList<>();
        this.findCombinations(candidates, target, 0, c);
        return this.res;
    }

    private void findCombinations(int[] candidates, int target, int index, LinkedList<Integer> c) {

        if (target == 0) {
            this.res.add((List<Integer>) c.clone());
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                c.addLast(candidates[i]);
                this.findCombinations(candidates, target - candidates[i], i, c);
                c.removeLast();
            }
        }
        // return;
    }
}
