package LeetCode208;

class Trie {

    class Node {
        boolean isWord;
        Node[] next;

        public Node() {
            this.isWord = false;
            this.next = new Node[26];
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new Node[26];
        }
    }

    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }

        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean search(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return true;
    }
}
