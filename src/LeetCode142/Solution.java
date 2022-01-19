package LeetCode142;

import listnode.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年01月19日
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>(10000);

        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if (map.containsKey(cur)) {
                return cur;
            } else {
                map.put(cur, index ++);
                cur = cur.next;
            }
        }
        return null;
    }
}
