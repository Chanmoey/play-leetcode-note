package LeetCode900;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Chanmoey
 * @date 2022年01月15日
 */
class RLEIterator {

    private final int[] encoding;
    int index = 0, output = 0;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
    }

    public int next(int n) {

        while (n > 0 && index < this.encoding.length) {
            int curElementCount = this.encoding[index];
            if (n + this.output <= curElementCount) {
                this.output += n;
                return this.encoding[index + 1];
            } else {
                n -= (curElementCount - this.output);
                this.output = 0;
                this.index += 2;
            }
        }
        return -1;
    }
}
