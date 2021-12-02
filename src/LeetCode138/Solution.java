package LeetCode138;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>(2500);

        Node dummyHead = new Node(-1);
        Node pre = dummyHead;
        Node cur = head;
        while (cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur, new Node(cur.val));
            }
            pre.next = map.get(cur);
            pre = pre.next;

            if (cur.random != null) {
                if (!map.containsKey(cur.random)) {
                    map.put(cur.random, new Node(cur.random.val));
                }
                pre.random = map.get(cur.random);
            }

            cur = cur.next;
        }

        return dummyHead.next;
    }
}
