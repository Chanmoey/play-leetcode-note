package LeetCode82;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 使用到Stack来辅组完成。
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();

        int delVal = -101;
        while (head != null) {
            if (stack.isEmpty()){
                if (delVal != head.val){
                    stack.push(head.val);
                }
            } else {
                if (stack.peek() == head.val) {
                    delVal = head.val;
                    stack.pop();
                } else if (head.val != delVal) {
                    stack.push(head.val);
                }
            }
            head = head.next;
        }

        if (stack.isEmpty()){
            return null;
        }

        ListNode dummyHead = new ListNode(-1);

        while (!stack.isEmpty()) {
            dummyHead.next = new ListNode(stack.pop(), dummyHead.next);
        }

        return dummyHead.next;
    }
}
