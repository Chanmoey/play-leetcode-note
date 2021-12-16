package LeetCode141;

import listnode.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Use Map
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        Map<ListNode, Integer> map = new HashMap<>();
        ListNode point = head;
        while (point != null) {
            if (map.containsKey(point)) {
                return true;
            } else {
                map.put(point, map.getOrDefault(point, 0) + 1);
            }

            point = point.next;
        }

        return false;
    }
}
