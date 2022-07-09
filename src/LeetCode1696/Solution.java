package LeetCode1696;

import java.util.LinkedList;

/**
 * @author Chanmoey
 * @date 2022年07月09日
 */
class Solution {
    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>(); // for storing indices
        list.add(0);
        for(int i=1; i<nums.length; i++){
            if(list.getFirst() < i-k) {
                list.removeFirst();
            }
            nums[i] += nums[list.getFirst()];
            while(!list.isEmpty() && nums[list.getLast()] <= nums[i]) {
                list.removeLast();
            }
            list.addLast(i);
        }
        return nums[nums.length-1];
    }
}
