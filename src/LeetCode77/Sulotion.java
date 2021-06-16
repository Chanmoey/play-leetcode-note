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

        // c中还有k - c.size()个空位，[i...n]中只要有k-c.size()个元素
        // i最多为 n - (k - c.size()) + 1
        for(int i = start; i <= n - (k - c.size()) + 1; i ++){
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }
        // return;
    }
    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if(k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n, k, 1, c);

        return res;
    }
}