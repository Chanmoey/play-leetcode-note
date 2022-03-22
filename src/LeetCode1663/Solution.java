package LeetCode1663;

/**
 * @author Chanmoey
 * @date 2022年03月22日
 */
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int temp = k - n;

            if (temp >= 26) {
                sb.append('z');
                k -= 26;
            } else {
                sb.append((char) ('a' + temp));
                k -= (temp + 1);
            }

            n --;
        }

        return sb.reverse().toString();
    }
}
