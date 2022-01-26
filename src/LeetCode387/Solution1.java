package LeetCode387;

import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年01月26日
 */
class Solution1 {
    public int firstUniqChar(String s) {
        int index = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            int iIndex = s.indexOf(i);
            if (iIndex != -1 && s.lastIndexOf(i) == iIndex) {
                index = Math.min(iIndex, index);
            }
        }

        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
