package LeetCode1844;

class Solution {
    public String replaceDigits(String s) {
        if (s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2) {
            chars[i] = (char) (chars[i-1] + chars[i] - '0');
        }

        return new String(chars);
    }
}
