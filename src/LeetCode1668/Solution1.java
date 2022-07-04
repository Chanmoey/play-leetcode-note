package LeetCode1668;

/**
 * TLE!
 *
 * @author Chanmoey
 * @date 2022年07月04日
 */
class Solution1 {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        int i = 0;
        while (i < sequence.length()) {
            if (sequence.charAt(i) == word.charAt(0)) {
                int temp = 0;
                int idx = i;
                while (idx < sequence.length()) {
                    if (idx + word.length() <= sequence.length() && sequence.startsWith(word, idx)) {
                        temp++;
                        idx += word.length();
                        res = Math.max(temp, res);
                    } else {
                        break;
                    }
                }
                i = idx;
                if (idx + word.length() > sequence.length()) {
                    break;
                }
            } else {
                i ++;
            }
        }

        return res;
    }
}