package LeetCode71;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        int period = 0;

        for (int i = 0; i < path.length(); i++) {
            if (period == 0) {
                switch (path.charAt(i)) {
                    case '.': {
                        if (stack.peek() != '/') {
                            stack.push('.');
                            break;
                        } else {
                            stack.push('.');
                            period++;
                            break;
                        }
                    }
                    case '/': {
                        if (stack.isEmpty()) {
                            stack.push('/');
                            break;
                        } else {
                            if (stack.peek() == '/') {
                                continue;
                            } else {
                                stack.push('/');
                            }
                        }
                        break;
                    }
                    default: {
                        stack.push(path.charAt(i));
                        period = 0;
                        break;
                    }
                }
            } else if (period == 1) {
                switch (path.charAt(i)) {
                    case '.': {
                        stack.push('.');
                        period++;
                        break;
                    }
                    case '/': {
                        stack.pop();
                        period = 0;
                        break;
                    }
                    default: {
                        stack.push(path.charAt(i));
                        period = 0;
                        break;
                    }
                }

            } else if (period == 2) {
                switch (path.charAt(i)) {
                    case '.': {
                        stack.push('.');
                        period = 0;
                        break;
                    }
                    case '/': {
                        int number = 2;
                        while (number != 0 && !stack.isEmpty()) {
                            if (stack.peek() == '/') {
                                number--;
                            }
                            stack.pop();
                        }
                        stack.push('/');
                        period = 0;
                        break;
                    }
                    default: {
                        stack.push(path.charAt(i));
                        period = 0;
                        break;
                    }
                }
            }
        }



        if (period == 1) {
            stack.pop();
        }

        if (period == 2) {
            int number = 2;
            while (number != 0 && !stack.isEmpty()) {
                if (stack.peek() == '/') {
                    number--;
                }
                stack.pop();
            }
        }

        if (stack.size() > 1 && stack.peek() == '/') {
            stack.pop();
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String path = "/a/./b/../../c/";
//        String path = "/a//b////c/d//././/..";
//        String path = "/.";
//        String path = "/..";
        String path = "/..hidden";
//        String path = "/hello../world";
        Solution s = new Solution();
        String sp = s.simplifyPath(path);
        System.out.println(sp);
    }
}
