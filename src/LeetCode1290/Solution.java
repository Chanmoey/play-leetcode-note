package LeetCode1290;


import ListNode.ListNode;

/**
 * @author Chanmoey
 * @date 2021年12月07日 8:39
 * @description
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res += head.val;
            if (head.next != null) {
                res <<= 1;
            }
            head = head.next;
        }

        return res;
    }
}
