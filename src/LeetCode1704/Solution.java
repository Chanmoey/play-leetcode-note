package LeetCode1704;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年12月01日
 */
class Solution {

    private static final Set<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');
    }

    public boolean halvesAreAlike(String s) {
        int left = 0;
        int right = 0;
        int i = 0;
        int j = s.length() >> 1;
        while (j < s.length()) {
            if (VOWELS.contains(s.charAt(i))) {
                left++;
            }
            if (VOWELS.contains(s.charAt(j))) {
                right++;
            }
            i++;
            j++;
        }

        return left == right;
    }
}
