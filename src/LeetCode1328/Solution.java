package LeetCode1328;

class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        } else if (palindrome.length() == 2) {
            StringBuilder sb = new StringBuilder(palindrome);
            if (palindrome.charAt(0) == 'a') {
                sb.replace(1, 2, "b");
            } else {
                sb.replace(0, 1, "a");
            }
            return sb.toString();
        } else if (palindrome.length() % 2 == 1) {
            for (int i = 0; i < palindrome.length(); i++) {
                if (i != palindrome.length() / 2) {
                    if (palindrome.charAt(i) != 'a') {
                        StringBuilder sb = new StringBuilder(palindrome);
                        sb.replace(i, i + 1, "a");
                        return sb.toString();
                    }
                }
            }
            StringBuilder sb = new StringBuilder(palindrome);
            sb.replace(palindrome.length() - 1, palindrome.length(), "b");
            return sb.toString();
        } else if (palindrome.length() % 2 == 0){
            for (int i = 0; i < palindrome.length(); i++) {
                if (palindrome.charAt(i) != 'a') {
                    StringBuilder sb = new StringBuilder(palindrome);
                    sb.replace(i, i + 1, "a");
                    return sb.toString();
                }
            }
            StringBuilder sb = new StringBuilder(palindrome);
            sb.replace(palindrome.length() - 1, palindrome.length(), "b");
            return sb.toString();
        }
        return "";
    }
}
