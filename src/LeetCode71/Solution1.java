package LeetCode71;

import java.util.Stack;

class Solution1 {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        for (int start = 1, i = 1; i <= path.length(); i++) {
            if (i == path.length() || path.charAt(i) == '/') {
                String f = path.substring(start, i);
                if (!f.isEmpty()) {
                    if (f.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else if (!f.equals(".")) {
                        stack.push(f);
                    }
                }

                start = i + 1;
            }
        }

        StringBuilder res = new StringBuilder();
        for (String e: stack) {
            res.append("/").append(e);
        }

        return res.toString().equals("") ? "/" : res.toString();
    }
}

