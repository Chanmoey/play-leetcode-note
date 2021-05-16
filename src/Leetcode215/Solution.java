package Leetcode215;/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quicksort(nums, 0, nums.length-1, k);
    }

    private int __partition(int[] nums, int l, int r){

        int v = nums[l];
        int j = l;
        int temp;
        for(int i = l + 1; i <= r; i++){
            if(nums[i] < v){
                temp = nums[i];
                nums[i] = nums[++j];
                nums[j] = temp;
            }
        }

        temp = nums[j];
        nums[j] = v;
        nums[l] = temp;

        return j;
    }

    private int quicksort(int[] nums, int l, int r, int k){
        int partition = __partition(nums, l, r);

        if(partition == (nums.length - k)){
            return nums[partition];
        }else if (partition < (nums.length - k)){
            return quicksort(nums, partition+1, r, k);
        }else {
            return quicksort(nums, l, partition-1, k);
        }
    }
}*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        QuickSort sort = new QuickSort();
        sort.quicksort(nums);
        return nums[nums.length - k];
    }
}