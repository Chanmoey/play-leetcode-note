package Leetcode125;

class Solution {
    public boolean isPalindrome(String s) {
        int s_length = s.length();
        char[] string_list = new char[s_length];

        String upperString = s.toUpperCase();
        char[] c = upperString.toCharArray();

        int length = 0;
        for(int i = 0; i < s_length; i++){
            if(isUpperAlphabetandNumber(c[i])){
                string_list[length++] = c[i];
            }
        }

        if(length == 0){
            return true;
        }

        int i = 0; int j = length - 1;
        while(i <= j){
            if(string_list[i] != string_list[j]){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

    private boolean isUpperAlphabetandNumber(char c){
        if((c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0')){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String strint = "0P";
        System.out.println(s.isPalindrome(strint));


    }
}
