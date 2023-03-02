package LeetCode443;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * <p>
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the array.
 * <p>
 * You must write an algorithm that uses only constant extra space.
 *
 * @author Chanmoey
 * @date 2023年03月02日
 */
class Solution1 {
    public int compress(char[] chars) {

        // idx指向的是字符
        int idx = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[idx]) {
                count++;
            } else {
                // 需要插入数字
                idx++;
                if (count > 1) {
                    if (count > 9) {
                        // idx往前移动，指向需要插入数字的地方
                        idx = putNum(chars, idx, count);
                    } else {
                        chars[idx] = (char) ('0' + count);
                        idx++;
                    }
                }
                chars[idx] = chars[i];
                count = 1;
            }
        }

        if (count != 1) {
            idx++;
            if (count > 9) {
                // idx往前移动，指向需要插入数字的地方
                idx = putNum(chars, idx, count);
                idx --;
            } else {
                chars[idx] = (char) ('0' + count);
            }
        }

        return idx + 1;
    }

    /**
     *
     * @param idx 需要插入的第一个位置
     * @return 新的idx
     */
    public int putNum(char[] chars, int idx, int num) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (num != 0) {
            stack.push(num % 10);
            num /= 10;
        }
        while (!stack.isEmpty()) {
            chars[idx++] = (char) ('0' + stack.pop());
        }

        return idx;
    }
}
