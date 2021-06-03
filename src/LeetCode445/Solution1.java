package LeetCode445;

import java.util.Stack;

/*
 * 通过使用栈来实现
 * */
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<ListNode> stack1 = new Stack<>(), stack2 = new Stack<>();

        ListNode node = l1;
        while (node != null) {
            stack1.push(node);
            node = node.next;
        }

        node = l2;
        while (node != null) {
            stack2.push(node);
            node = node.next;
        }

        ListNode dummyHead = new ListNode(-1, null);

        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = 0;

            if (!stack1.isEmpty()) {
                x += stack1.pop().val;
            }

            if (!stack2.isEmpty()) {
                x += stack2.pop().val;
            }

            x += carry;

            dummyHead.next = new ListNode(x % 10, dummyHead.next);

            carry = x / 10;
        }

        return dummyHead.next;
    }
}
