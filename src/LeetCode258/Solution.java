package LeetCode258;

class Solution {
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int cur = num % 10;
        int result = cur + addDigits(num / 10);
        if (result > 9) {
            return addDigits(result);
        } else {
            return result;
        }
    }
}