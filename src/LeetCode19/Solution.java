package LeetCode19;


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

// 双索引
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        assert n >= 0;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i ++) {
            assert q != null;
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode = null;

        ListNode retNode = dummyHead.next;
        dummyHead = null;

        return retNode;

    }
}
