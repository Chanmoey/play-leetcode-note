package LeetCode709;

/**
 * @author Chanmoey
 * @date 2022年03月06日
 */
class Solution1 {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) ('a' + (c - 'A'));
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
