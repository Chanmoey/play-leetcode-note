package LeetCode143;



import java.util.*;

class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        Deque<ListNode> queue = new ArrayDeque<>();
        Stack<ListNode> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            queue.addLast(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        queue.addLast(slow);

        slow = slow.next;
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            pre.next = queue.removeFirst();
            pre = pre.next;
            pre.next = null;
            pre.next = stack.pop();
            pre = pre.next;
            pre.next = null;
        }

        if (!queue.isEmpty()) {
            pre.next = queue.remove();
            pre = pre.next;
            pre.next = null;
        }

        head = dummyHead.next;
//        ListNode cur = head;
//        while (cur != null) {
//            System.out.println(cur.val);
//            cur = cur.next;
//        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, null);
        head.next = new ListNode(4, head.next);
        head.next = new ListNode(3, head.next);
        head.next = new ListNode(2, head.next);
        head.next = new ListNode(1, head.next);
        head = head.next;

        Solution s = new Solution();
        s.reorderList(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
