package LeetCode7;

class Solution {
    public int reverse(int x) {
        if (x == 0){
            return x;
        }

        int sige = x > 0 ? 1 : -1;

        x = Math.abs(x);

        long reverseNum = 0;
        while (x != 0){
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        if(sige == -1){
            reverseNum = -reverseNum;
        }

        if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE){
            return 0;
        }

        return (int)reverseNum;
    }
}