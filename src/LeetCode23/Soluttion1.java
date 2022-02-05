package LeetCode23;

import listnode.ListNode;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年02月05日
 */
class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> array = this.listNode2Array(lists);
        Collections.sort(array);
        return this.array2ListNode(array);
    }

    private List<Integer> listNode2Array(ListNode[] lists) {
        List<Integer> array = new ArrayList<>();

        ListNode cur = null;
        for (ListNode list : lists) {
            cur = list;
            while (cur != null) {
                array.add(cur.val);
                cur = cur.next;
            }
        }

        return array;
    }

    private ListNode array2ListNode(List<Integer> array) {
        if (array.isEmpty()) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        for (Integer integer : array) {
            cur.next = new ListNode(integer);
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
