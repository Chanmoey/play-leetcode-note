package LeetCode1805;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年02月01日
 */
class Solution {
    public int numDifferentIntegers(String word) {
        List<String> stringList = this.splitNumber(word);
        return this.deletePreZero(stringList).size();
    }

    private List<String> splitNumber(String word) {
        StringBuilder sb = new StringBuilder(word.length());
        List<String> stringList = new ArrayList<>();
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (!sb.isEmpty()) {
                    stringList.add(sb.toString());
                    sb.delete(0,sb.length());
                }
            }
        }
        if (!sb.isEmpty()) {
            stringList.add(sb.toString());
        }

        return stringList;
    }

    private Set<Integer> stringToNumber(List<String> stringList) {
        Set<Integer> set = new HashSet<>(stringList.size());
        for (String s : stringList) {
            int number = 0;
            for (char c : s.toCharArray()) {
                number = number * 10 + c - '0';
            }
            set.add(number);
        }

        return set;
    }

    private Set<String> deletePreZero(List<String> stringList) {
        Set<String> set = new HashSet<>(stringList.size());
        for (String s : stringList) {
            char[] chars = s.toCharArray();
            int i = 0;
            while (i < chars.length) {
                if (chars[i] != '0') {
                    break;
                }
                i++;
            }
            if (i == chars.length) {
                set.add("0");
            } else {
//                char[] copy = new char[chars.length - i];
//                System.arraycopy(chars, i, copy, 0, copy.length);
//                set.add(new String(copy));
                set.add(s.substring(i));
            }
        }
        return set;
    }
}
