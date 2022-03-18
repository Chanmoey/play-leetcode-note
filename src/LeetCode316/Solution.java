package LeetCode316;

import java.util.Stack;

/**
 * @author Chanmoey
 * @date 2022年03月18日
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        for (char aChar : chars) {
            freq[aChar - 'a']++;
        }

        for (char c : chars) {
            freq[c - 'a']--;

            if (visited[c - 'a']) {
                continue;
            }

            while (stack.size() > 0 && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                char pop = stack.pop();
                visited[pop - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return String.valueOf(res);
    }
}
