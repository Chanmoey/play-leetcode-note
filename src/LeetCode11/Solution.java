package LeetCode11;/*
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int container;
        int l = height[0];
        int r = height[height.length-1];
        for(int i = 0; i < height.length; i++){
            if(height[i] < l)
                continue;
            else
                l = height[i];
            for(int j = height.length-1; j > i; j--){
                container = Math.min(height[i], height[j]) * (j - i);
                if(container > max){
                    max = container;
                }
            }
        }

        return max;
    }
}*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int container = 0, max = 0;
        while (left < right){
            if(height[left] < height[right]){
                container = height[left] * (right - left);
                left++;
            }
            else {
                container = height[right] * (right - left);
                right --;
            }

            max = Math.max(max, container);
        }

        return max;
    }
}
