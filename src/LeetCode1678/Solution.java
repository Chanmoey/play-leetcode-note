package LeetCode1678;

/**
 * @author Chanmoey
 * @date 2022年03月05日
 */
class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == '(') {
                int j = i + 1;
                while (command.charAt(j) != ')') {
                    j++;
                }
                if (j - i > 1) {
                    sb.append("al");
                } else {
                    sb.append('o');
                }

                i = j - 1;
            }
        }

        return sb.toString();
    }
}
