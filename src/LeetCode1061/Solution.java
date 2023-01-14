package LeetCode1061;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误的
 *
 * @author Chanmoey
 * @date 2023年01月14日
 */
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 'a'; i <= 'z'; i++) {
            map.put((char) i, (char) i);
        }

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            char c = map.get(a);
            char d = map.get(b);

            char minC = (char) Math.min(a, Math.min(b, Math.min(c, d)));

            map.put(a, minC);
            map.put(b, minC);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append(map.get(baseStr.charAt(i)));
        }

        return sb.toString();
    }
}
