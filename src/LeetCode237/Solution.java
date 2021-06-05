package LeetCode237;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {

        if (node == null) {
            return;
        }

        if (node.next == null) {
            node = null;
            return;
        }

        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
        delNode = null;
    }
}
