package LeetCode206;

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

class Solution {

    // 时间复杂度O(n)
    // 空间复杂度O(n)
    /*public ListNode reverseList(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode dummyHead = new ListNode(0, null);

        while (head != null) {
            dummyHead.next = new ListNode(head.val, dummyHead.next);
            head = head.next;
        }

        return dummyHead.next;
    }*/

    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public ListNode reverseList(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
