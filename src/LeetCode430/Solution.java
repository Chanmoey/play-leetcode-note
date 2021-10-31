package LeetCode430;

import java.util.Stack;

class Solution {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
// 还没完成的😭
/*    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        this.dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node cur = head;
        Node future = head.next;

        while (future == null && cur.child != null) {
            Node child = cur.child;
            cur.next = child;
            child.prev = cur;
            cur = dfs(child);
        }

        while (future != null) {
            if (cur.child != null) {
                Node child = cur.child;
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                cur = dfs(child);
            }

            cur.next = future;
            future.prev = cur;
            cur = future;
            future = future.next;
        }
        return cur;
    }*/

    public Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        Node prev = null;
        Node newHead = null;
        while(!stack.isEmpty()) {
            Node currNode = stack.pop();
            if (prev == null) {
                prev = currNode;
                newHead = prev;
            }
            else {
                prev.next = currNode;
                prev.child = null;
                currNode.prev = prev;
                prev = currNode;
            }
            if (currNode.next != null) {
                stack.push(currNode.next);
            }
            if (currNode.child != null) {
                stack.push(currNode.child);
            }
        }
        return newHead;
    }
}
