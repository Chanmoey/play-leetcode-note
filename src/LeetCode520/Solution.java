package LeetCode520;

/**
 * @author Chanmoey
 * @date 2022年01月24日
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalFreq = 0;
        boolean firstIsCapital = false;
        if (Character.isUpperCase(word.charAt(0))) {
            firstIsCapital = true;
            capitalFreq++;
        }

        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitalFreq++;
            }
        }

        // 如果只有首字母大写，或全部字母小写，或全部字母大写，则返回true，否则false。
        return capitalFreq == 1 && firstIsCapital
                || capitalFreq == 0
                || capitalFreq == word.length();

    }
}