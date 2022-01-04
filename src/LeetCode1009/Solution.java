package LeetCode1009;

/**
 * @author Chanmoey
 * @date 2022年01月04日
 */
class Solution {
    public int bitwiseComplement(int n) {

        if (n == 0) {
            return 1;
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int last = n & 1;
            sb.append(last == 1 ? 0 : 1);
            n >>= 1;
        }

        return Integer.parseInt(sb.reverse().toString(), 2);
    }
}
