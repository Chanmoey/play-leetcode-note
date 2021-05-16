package LeetCode1672;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        int temp = 0;
        for (int[] account : accounts) {
            temp = sum(account);
            if (richest < temp) {
                richest = temp;
            }
        }

        return richest;
    }

    private int sum(int[] num){
        int result = 0;
        for (int j : num) {
            result += j;
        }

        return result;
    }
}