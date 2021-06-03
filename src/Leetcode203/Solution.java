package Leetcode203;

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // 头节点做单独处理
        while (head != null && head.val == val){
            head = head.next;
        }

        if(head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else
                prev = prev.next;
        }

        return head;
    }
}