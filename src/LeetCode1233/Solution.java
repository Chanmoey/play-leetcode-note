package LeetCode1233;

import java.util.*;

/**
 * 使用trie字典树。
 *
 * @author Chanmoey
 * @date 2022年06月10日
 */
class Solution {

    public List<String> removeSubfolders(String[] folder) {
        Tire tire = new Tire();
        List<String> result = new ArrayList<>();
        Arrays.sort(folder);

        for (String s : folder) {
            if (tire.insert(s)) {
                result.add(s);
            }

        }

        return result;
    }
}

class Tire {
    private static class Node {
        private final Map<String, Node> map = new HashMap<>();
        private boolean flag;
    }

    private final Node root;

    public Tire() {
        this.root = new Node();
    }

    public boolean insert(String s) {
        Node cur = this.root;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= s.length(); i++) {
            if (i != s.length() && s.charAt(i) != '/') {
                sb.append(s.charAt(i));
                continue;
            }

            if (this.contains(sb.toString(), cur)) {
                this.put(sb.toString(), new Node(), cur);
            }

            cur = this.get(sb.toString(), cur);
            sb = new StringBuilder();

            if (this.checkFlag(cur)) {
                return false;
            }
        }

        this.setFlag(cur);
        return true;
    }

    public boolean contains(String s, Node node) {
        return node.map.get(s) == null;
    }

    public void put(String s, Node node, Node cur) {
        cur.map.put(s, node);
    }

    public void setFlag(Node node) {
        node.flag = true;
    }

    public boolean checkFlag(Node node) {
        return node.flag;
    }

    public Node get(String s, Node node) {
        return node.map.get(s);
    }
}
