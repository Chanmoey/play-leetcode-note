package LeetCode771;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < J.length(); i ++){
            Character cur = J.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < S.length(); i ++) {
            Character c = S.charAt(i);
            if (map.containsKey(c)) {
                res ++;
            }
        }

        return res;
    }
}