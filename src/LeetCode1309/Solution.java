package LeetCode1309;

/**
 * @author Chanmoey
 * @date 2022年03月06日
 */
class Solution {
    public String freqAlphabets(String s) {
        int[] container = new int[s.length()];
        int index = 0;

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                for (int i = 0; i < index - 2; i++) {
                    sb.append((char) ('a' + container[i] - 1));
                }
                sb.append((char) ('a' + (container[index - 2]) * 10 + (container[index - 1]) - 1));
                index = 0;
            }else {
                container[index] = c - '0';
                index++;
            }
        }

        for (int i = 0; i < index; i++) {
            sb.append((char) ('a' + container[i] - 1));
        }
        return sb.toString();
    }
}
