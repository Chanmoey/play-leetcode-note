package LeetCode9;

class Solution {
    public boolean isPalindrome(int x) {

        if( (x % 10 == 0 && x != 0) || x < 0){
            return false;
        }

        int reverse = 0;

        int copyX = x;
        while(copyX > 0){
            reverse = reverse * 10 + copyX % 10;
            copyX /= 10;
        }

        return reverse == x;
    }
}
