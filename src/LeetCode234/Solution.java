package LeetCode234;


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

class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        int[] array = new int[100000];
        int index = 0;

        while (head != null) {
            array[index++] = head.val;
            head = head.next;
        }

        int i = 0, j = index - 1;
        while (i <= j) {
            if (array[i++] != array[j--]) {
                return false;
            }
        }

        return true;
    }
}
