package LeetCode500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年02月14日
 */
class Solution {

    private static final String FIRST = "qwertyuiop";
    private static final String SECOND = "asdfghjkl";
    private static final String THIRD = "zxcvbnm";

    private static final Map<Character, Integer> MAP = new HashMap<>(26 * 2);

    public String[] findWords(String[] words) {

        this.initMap();

        List<String> res = new ArrayList<>(words.length);
        int index;
        boolean cow;
        for (String s : words) {

            cow = true;
            index = MAP.get(Character.toLowerCase(s.charAt(0)));
            for (int i = 1; i < s.toCharArray().length; i++) {
                if (index != MAP.get(Character.toLowerCase(s.charAt(i)))) {
                    cow = false;
                    break;
                }
            }

            if (cow) {
                res.add(s);
            }
        }

        return res.toArray(new String[0]);
    }

    private void initMap() {
        for (char c : FIRST.toCharArray()) {
            MAP.put(c, 1);
        }

        for (char c : SECOND.toCharArray()) {
            MAP.put(c, 2);
        }

        for (char c : THIRD.toCharArray()) {
            MAP.put(c, 3);
        }
    }
}
