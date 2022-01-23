package LeetCode1291;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年01月23日
 */
class Solution {

    private final List<Integer> res = new ArrayList<>();
    private static final int LARGEST_SINGLE_DIGIT = 9;

    public List<Integer> sequentialDigits(int low, int high) {

        for (int i = 1; i < LARGEST_SINGLE_DIGIT; i++) {
            this.sequentialDigit(i, i, low, high);
        }


        Collections.sort(this.res);
        return this.res;
    }

    private int getNumberLength(int number) {
        int length = 0;
        while (number > 0) {
            number >>= 1;
            length++;
        }

        return length;
    }

    private int getNumberStart(int number, int length) {
        for (int i = 0; i < length - 1; i++) {
            number >>= 1;
        }

        return number;
    }

    private void sequentialDigit(int number, int pre, int low, int high) {

        if (number > high) {
            return;
        }

        if (number >= low) {
            this.res.add(number);
        }

        if (pre == LARGEST_SINGLE_DIGIT) {
            return;
        }

        sequentialDigit(number * 10 + (pre + 1), (pre + 1), low, high);
    }
}
