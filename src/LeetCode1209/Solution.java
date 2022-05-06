package LeetCode1209;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chanmoey
 * @date 2022年05月06日
 */
class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int dup = 0;
        for (char aChar : chars) {
            // 栈空单独考虑
            if (stack.isEmpty()) {
                stack.addLast(aChar);
                dup = 1;
            } else { // 非栈空情况
                if (stack.peekLast() == aChar) {
                    stack.addLast(aChar);
                    dup++;
                    if (dup == k) {
                        while (!stack.isEmpty() && dup > 0) {
                            stack.removeLast();
                            dup--;
                        }

                        if (stack.isEmpty()) {
                            dup = 0;
                        } else {
                            char[] stackOutput = new char[k - 1];
                            int idx = 0;
                            stackOutput[idx] = stack.removeLast();
                            idx++;
                            dup = 1;
                            while (!stack.isEmpty() && idx < k - 1) {
                                if (stack.peekLast() == stackOutput[0]) {
                                    dup++;
                                    stackOutput[idx] = stack.removeLast();
                                    idx++;
                                } else {
                                    break;
                                }
                            }
                            for (int j = 0; j < idx; j++) {
                                stack.addLast(stackOutput[j]);
                            }
                        }
                    }
                } else {
                    stack.addLast(aChar);
                    dup = 1;
                }
            }
        }

        Character[] characters = stack.toArray(new Character[0]);
        StringBuilder sb = new StringBuilder();
        for (Character c : characters) {
            sb.append(c);
        }

        return sb.toString();
    }
}
