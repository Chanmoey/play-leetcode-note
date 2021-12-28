package listnode;


/**
 * @author Chen
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode creatList(int[] arr) {
        ListNode head = new ListNode(arr[0], null);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i], null);
            cur = cur.next;
        }

        return head;
    }
}

