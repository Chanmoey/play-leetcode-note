package LeetCode150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    Integer last = stack.pop();
                    Integer before = stack.pop();
                    stack.push(before + last);
                    break;
                }
                case "-": {
                    Integer last = stack.pop();
                    Integer before = stack.pop();
                    stack.push(before - last);
                    break;
                }
                case "*": {
                    Integer last = stack.pop();
                    Integer before = stack.pop();
                    stack.push(before * last);
                    break;
                }
                case "/": {
                    Integer last = stack.pop();
                    Integer before = stack.pop();
                    stack.push(before / last);
                    break;
                }
                default: {

                    int number = 0;
                    if (token.charAt(0) == '-') {
                        for (int i = 1; i < token.length(); i++) {
                            number = number * 10 + (token.charAt(i) - '0');
                        }
                        stack.push(-number);
                    } else {
                        for (int i = 0; i < token.length(); i++) {
                            number = number * 10 + (token.charAt(i) - '0');
                        }
                        stack.push(number);
                    }
                    break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        Solution solution = new Solution();
        solution.evalRPN(tokens);
    }
}
