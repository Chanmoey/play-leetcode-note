package Leetcode344;

class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char temp;
        while (i < j){
            temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
