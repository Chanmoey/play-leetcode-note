package Leetcode215;

public class QuickSort {

    // 快速排序[r...l]的数组
    public void quicksort(int[] nums){
        quicksort(nums, 0, nums.length-1);
    }

    //[l+1...j] < v ; [j+1...i-1] > p
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

    private void quicksort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }

        int partition = __partition(nums, l, r);
        quicksort(nums, l, partition-1);
        quicksort(nums, partition+1, r);
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        qs.quicksort(nums);

        for(int num:nums){
            System.out.print(num);
            System.out.print(' ');
        }
    }
}
