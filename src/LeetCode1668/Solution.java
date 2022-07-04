package LeetCode1668;

/**
 * @author Chanmoey
 * @date 2022年07月04日
 */
class Solution {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        for (int i = 0; i < sequence.length(); i ++) {
            if (sequence.charAt(i) == word.charAt(0)) {
                int temp = 0;
                int idx = i;
                while (idx < sequence.length()) {
                    if (idx + word.length() <= sequence.length() && sequence.substring(idx, idx + word.length()).equals(word)) {
                        temp++;
                        idx += word.length();
                        res = Math.max(temp, res);
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
