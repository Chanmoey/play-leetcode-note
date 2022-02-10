package LeetCode763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年02月10日
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] scope = new int[26][2];

        for (int[] ints : scope) {
            Arrays.fill(ints, -1);
        }

        // 统计字符所在区间
        int count = 0;
        int index;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if (scope[index][0] == -1) {
                scope[index] = new int[]{i, i};
                count++;
            } else {
                scope[index][1] = i;
            }
        }

        index = 0;
        int[][] boundary = new int[count][2];
        for (int[] border : scope) {
            if (border[0] != -1) {
                boundary[index++] = border;
            }
        }

        // 按区间开头排序
        Arrays.sort(boundary, Comparator.comparingInt(a -> a[0]));

        // 合并区间并计算长度
        List<Integer> res = new ArrayList<>();
        int[] word;
        int j;
        for (int i = 0; i < boundary.length; i++) {
            word = boundary[i];
            j = i + 1;
            for (; j < boundary.length; j++) {
                if (word[1] > boundary[j][0]) {
                    word[1] = Math.max(word[1], boundary[j][1]);
                } else {
                    res.add(word[1] - word[0] + 1);
                    i = j - 1;
                    break;
                }
            }
            if (j >= boundary.length) {
                res.add(word[1] - word[0] + 1);
                break;
            }
        }

        return res;
    }
}
