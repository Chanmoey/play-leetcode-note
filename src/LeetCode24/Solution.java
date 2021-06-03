package LeetCode24;

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
    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }

        // 如果担心内存泄露，需要将dummyHead所申请的空间释放掉。
        return dummyHead.next;
    }
}
