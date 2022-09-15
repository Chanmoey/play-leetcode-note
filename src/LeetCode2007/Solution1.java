package LeetCode2007;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年09月15日
 */
public class Solution1 {

    private final int[] map = new int[100001];

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[]{};
        }

        Arrays.sort(changed);

        int[] res = new int[changed.length / 2];
        int remaining = 0;
        int index = 0;
        for (int j : changed) {
            if (j % 2 == 1) {
                if (j * 2 <= 100000 && map[j * 2] > 0) {
                    map[j * 2]--;
                    res[index++] = j;
                    remaining--;
                } else {
                    map[j]++;
                    remaining++;
                }
            } else {
                if (map[j / 2] > 0) {
                    res[index++] = j / 2;
                    map[j / 2]--;
                    remaining--;
                } else if (j * 2 <= 100000 && map[j * 2] > 0) {
                    map[j * 2]--;
                    res[index++] = j;
                    remaining--;
                } else {
                    map[j]++;
                    remaining++;
                }
            }
        }

        if (remaining > 0) {
            return new int[]{};
        }

        return res;
    }
}
