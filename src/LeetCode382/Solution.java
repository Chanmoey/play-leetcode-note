package LeetCode382;

import listnode.ListNode;

import java.util.Random;

/**
 * @author Chanmoey
 * @date 2022年01月07日
 */
public class Solution {
    private final ListNode head;
    private int size;
    private final Random random = new Random();

    public Solution(ListNode head) {
        this.head = head;
        ListNode counter = head;
        this.size = 0;
        while (counter != null) {
            this.size++;
            counter = counter.next;
        }
    }

    public int getRandom() {
        int index = random.nextInt(this.size);
        ListNode cur = head;
        for (int i = 1; i <= index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }
}
