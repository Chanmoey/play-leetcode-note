package LeetCode216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.res = new ArrayList<>();
        LinkedList<Integer> c = new LinkedList<>();
        this.findCombinations(k, n, 1, c);
        return this.res;
    }

    private void findCombinations(int k, int n, int index, LinkedList<Integer> c) {
        if (c.size() == k) {
            if (n == 0) {
                this.res.add((List<Integer>) c.clone());
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (i <= n) {
                c.addLast(i);
                this.findCombinations(k, n - i, i + 1, c);
                c.removeLast();
            }
        }
    }
}
