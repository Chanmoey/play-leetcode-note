package LeetCode77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private ArrayList<List<Integer>> res;

    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){

        if(c.size() == k){
            res.add((List<Integer>)c.clone());
            return;
        }

        for(int i = start; i <= n - (k - c.size()) + 1; i ++){
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }

        return;
    }
    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(n, k, 1, c);

        return res;

    }
}