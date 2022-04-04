package LeetCode1721;

import listnode.ListNode;

/**
 * @author Chanmoey
 * @date 2022年04月04日
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pointer = dummyHead;

        // 计算链表长度。
        int length = -1;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }

        if (length == 1) {
            return head;
        }

        // 从后往前 第k个节点 的 前一个位置。
        int endKthPreIdx = length - k;
        pointer = dummyHead;

        // 从前往后 第k个 和从后往前 第k个 重合。
        if (k == endKthPreIdx + 1) {
            return dummyHead.next;
        }

        // 如果 从后往前 第k个 的索引比从前往后第k个节点的索引还靠前，交换两个的逻辑关系。（原理的从前往后第k变成从后往前的第k。）
        if (endKthPreIdx + 1 < k) {
            int swap = endKthPreIdx;
            endKthPreIdx = k - 1;
            k = swap + 1;
        }

        ListNode kthPre = new ListNode();
        ListNode kth = new ListNode();
        ListNode endKthPre = new ListNode();
        ListNode endKth = new ListNode();
        int cur = 0;
        while (cur <= endKthPreIdx + 1) {
            if (cur == k - 1) {
                kthPre = pointer;
            } else if (cur == k) {
                kth = pointer;
            } else if (cur == endKthPreIdx) {
                endKthPre = pointer;
            } else if (cur == endKthPreIdx + 1) {
                endKth = pointer;
            }

            cur++;
            pointer = pointer.next;
        }

        // 如果从前往后第k和从后往前第靠在一起，特殊考虑。
        if (k == endKthPreIdx) {
            kthPre.next = endKth;
            kth.next = endKth.next;
            endKth.next = kth;
            return dummyHead.next;
        }

        ListNode temp = endKth.next;
        kthPre.next = endKth;
        endKth.next = kth.next;
        kth.next = temp;
        endKthPre.next = kth;

        return dummyHead.next;
    }
}
