package LeetCode167;/*
二分搜索的思想
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];

        for(int i = 0; i < numbers.length; i++){
            int other = binarySearch(numbers, i+1, numbers.length-1, target - numbers[i]);
            if(other != 0){
                index[0] = i + 1;
                index[1] = other + 1;
                return index;
            }
        }
            return index;
        }


    private int binarySearch(int[] numbers,int l, int r, int target){
        int low = l, high = r;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(numbers[mid] == target){
                return (mid);
            }
            else if(numbers[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return 0;
    }
}*/


// 对撞指针
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];

        int l = 0, r = numbers.length - 1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                index[0] = l+1;
                index[1] = r+1;
                return index;
            }
            else if(numbers[l] + numbers[r] > target){
                r--;
            }else {
                l++;
            }
        }
        return index;
    }
}
