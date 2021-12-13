package LeetCode1446;

/**
 * @author Chanmoey
 */
class Solution {
    public int maxPower(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int power = -1;
        for (int i = 0; i < s.length(); i++) {
            int transition = 1;
            char c = s.charAt(i);
            for (int j = i + 1; j < s.length(); j ++) {
                if (c == s.charAt(j)) {
                    transition ++;
                } else {
                    i = j - 1;
                    break;
                }
            }
            power = Math.max(power, transition);
        }

        return power;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxPower("tourist"));
    }
}
