package LeetCode139;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int size = word.length();
                if (size <= i && dp[i - size] && word.equals(s.substring(i - size, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");
        if (s.wordBreak("cars", wordDict)) {
            System.out.println("Accepted");
        } else {
            System.out.println("Wrong");
        }
    }
}
