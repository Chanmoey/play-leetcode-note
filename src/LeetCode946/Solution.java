package LeetCode946;

/**
 * @author Chanmoey
 * @date 2022年03月16日
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int stackIdx = -1;

        int popIdx = 0;

        for (int e : pushed) {
            stack[++stackIdx] = e;

            while (stackIdx >= 0 && stack[stackIdx] == popped[popIdx]) {
                stackIdx--;
                popIdx++;
            }

        }

        return popped.length == popIdx;
    }
}
