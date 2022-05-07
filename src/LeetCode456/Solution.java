package LeetCode456;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chanmoey
 * @date 2022年05月07日
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length <= 2) {
            return false;
        }

        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i-1],nums[i]);
        }

        Deque<Integer> stack = new LinkedList<>();
        for(int j = nums.length-1; j >= 0; j--){
            while(!stack.isEmpty() && stack.peekLast() <= min[j]){
                stack.removeLast();
            }
            if(!stack.isEmpty() && stack.peekLast() < nums[j]) {
                return true;
            }
            stack.addLast(nums[j]);
        }
        return false;
    }
}
