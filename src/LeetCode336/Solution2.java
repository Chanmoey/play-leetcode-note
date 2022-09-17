package LeetCode336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年09月17日
 */
class Solution2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        int[] hasLength = new int[5002];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
            hasLength[words[i].length()]++;
        }

        if (map.containsKey("")) {
            int blankIdx = map.get("");
            for (int i = 0; i < words.length; i++) {

                if (i == blankIdx) {
                    continue;
                }

                if (isPalindrome(words[i])) {
                    res.add(Arrays.asList(blankIdx, i));
                    res.add(Arrays.asList(i, blankIdx));
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String reverse = reverseStr(words[i]);
            if (map.containsKey(reverse)) {
                int reverseIdx = map.get(reverse);
                if (reverseIdx == i) {
                    continue;
                }
                res.add(Arrays.asList(i, reverseIdx));
            }
        }


        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {
                if (hasLength[cur.length() - cut] > 0 && isPalindrome(cur, 0, cut - 1)) {
                    String reverse = reverseStr(cur.substring(cut));
                    if (map.containsKey(reverse)) {
                        int reverseIdx = map.get(reverse);
                        if (reverseIdx == i) {
                            continue;
                        }
                        res.add(Arrays.asList(reverseIdx, i));
                    }
                }
                if (hasLength[cut] > 0 && isPalindrome(cur, cut, cur.length() - 1)) {
                    String reverse = reverseStr(cur.substring(0, cut));
                    if (map.containsKey(reverse)) {
                        int reverseIdx = map.get(reverse);
                        if (reverseIdx == i) {
                            continue;
                        }
                        res.add(Arrays.asList(i, reverseIdx));
                    }
                }
            }
        }

        return res;
    }

    public String reverseStr(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }
}
