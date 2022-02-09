package LeetCode409;

/**
 * @author Chanmoey
 * @date 2022年02月09日
 */
class Solution1 {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for (char ch : s.toCharArray()) {
            counts[ch]++;
        }
        int result = 0;
        for (int count : counts) {
            result += count - (count % 2);
        }
        return Math.min(result + 1, s.length());
    }
}
