package LeetCode1239;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年10月24日
 */
class Solution {

    private int max = 0;

    public int maxLength(List<String> arr) {

        for (int i = 0; i < arr.size(); i++) {
            int[] bitmap = createBitmap(arr.get(i));
            if (bitmap.length == 0) {
                continue;
            }

            if (backtracking(arr, bitmap, 1, arr.get(i))) {
                return max;
            }
        }

        return max;
    }

    /**
     * if return {true}, No need to keep searching.
     */
    private boolean backtracking(List<String> arr, int[] bitmap, int index, String origin) {

        max = Math.max(origin.length(), max);

        if (index == arr.size()) {
            return true;
        }

        for (int i = index; i < arr.size(); i++) {
            int[] tempBitMap = Arrays.copyOf(bitmap, bitmap.length);
            String str = arr.get(i);
            int j = 0;
            for (; j < str.length(); j++) {
                if (tempBitMap[str.charAt(j) - 'a'] != 0) {
                    //  有相同的字母，跳出，不再查看。
                    break;
                }
                tempBitMap[str.charAt(j) - 'a'] = 1;

            }

            if (j == str.length() && backtracking(arr, tempBitMap, index + 1, origin + str)) {
                return true;
            }

        }

        return false;
    }

    private int[] createBitmap(String str) {
        int[] bitmap = new int[26];
        for (char c : str.toCharArray()) {
            if (bitmap[c - 'a'] == 1) {
                return new int[0];
            }
            bitmap[c - 'a']++;
        }
        return bitmap;
    }
}
