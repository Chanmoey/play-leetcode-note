package LeetCode1328;

class Solution1 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        int n = palindrome.length() / 2;
        char[] chars = palindrome.toCharArray();

        for (int i = 0; i < n; i ++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }

        chars[palindrome.length() - 1] = 'b';
        return new String(chars);
    }
}
