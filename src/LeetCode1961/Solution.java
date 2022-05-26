package LeetCode1961;

/**
 * @author Chanmoey
 * @date 2022年05月26日
 */
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int sLen = s.length();
        int preLen = 0;
        StringBuilder sb = new StringBuilder();

        // create a preString, and preString.length() == s.length()
        for (String word : words) {
            if (preLen < sLen) {
                preLen += word.length();
                sb.append(word);
            } else if (preLen > sLen) {
                return false;
            } else {
                break;
            }
        }

        if (!sb.isEmpty() && sb.length() == sLen) {
            String pre = sb.toString();
            return this.isPre(pre, s);
        }

        return false;
    }

    private boolean isPre(String origin, String target) {
        assert origin.length() == target.length();

        for (int j = 0; j < origin.length(); j++) {
            if (origin.charAt(j) != target.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
