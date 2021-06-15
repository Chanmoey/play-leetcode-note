package LeetCode46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private ArrayList<List<Integer>> res;
    private boolean[] used;

    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){

        if(index == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for(int i = 0; i < nums.length; i ++)
            if(!used[i]){
                p.addLast(nums[i]);
                used[i] = true;
                generatePermutation(nums, index+1, p);
                p.removeLast();
                used[i] = false;
            }
        // return; 结束递归逻辑。
    }

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];

        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);

        return res;
    }
}