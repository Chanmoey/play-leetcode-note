package LeetCode876;


import listnode.ListNode;

import java.util.List;

/**
 * @author Chanmoey
 * @date 2021年12月28日
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode countPointer = head;
        int count = 0;
        while (countPointer != null) {
            count++;
            countPointer = countPointer.next;
        }

        if (count == 1) {
            return head;
        }

        int middle = count / 2 + 1;
        ListNode cur = head;
        int index = 1;
        while (index < middle) {
            cur = cur.next;
            index++;
        }

        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.creatList(new int[]{1, 2, 3, 4, 5});
        ListNode middle = s.middleNode(head);
    }
}
