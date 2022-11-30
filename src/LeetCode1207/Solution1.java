package LeetCode1207;

/**
 * 更慢了
 *
 * @author Chanmoey
 * @date 2022年11月30日
 */
public class Solution1 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] map = new int[2001];
        int[] set = new int[2001];

        for (int num : arr) {
            map[num + 1000]++;
        }

        for (int freq : map) {
            if (set[freq] != 0) {
                return false;
            } else {
                set[freq] = freq;
            }
        }

        return true;
    }
}
