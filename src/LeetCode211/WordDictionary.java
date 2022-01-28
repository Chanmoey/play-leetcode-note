package LeetCode211;

/**
 * 使用Trie的思想。
 *
 * @author Chanmoey
 * @date 2022年01月28日
 */
class WordDictionary {

    private static final char ANY_CHAR = '.';
    private static final int LETTER_LENGTH = 26;

    static class Node {
        char c;
        Node[] child;
        boolean word;

        public Node(char c) {
            this.c = c;
            child = new Node[26];
            word = false;
        }
    }

    private final Node dummyRoot;

    public WordDictionary() {
        this.dummyRoot = new Node('*');
    }

    public void addWord(String word) {
        Node cur = this.dummyRoot;
        for (char ch : word.toCharArray()) {
            if (cur.child[ch - 'a'] == null) {
                cur.child[ch - 'a'] = new Node(ch);
            }
            cur = cur.child[ch - 'a'];
        }
        cur.word = true;

    }

    public boolean search(String word) {
        return this.helper(this.dummyRoot, 0, word);
    }

    public boolean helper(Node root, int idx, String word) {
        if (idx >= word.length()) {
            return root.word;
        }
        if (word.charAt(idx) == ANY_CHAR) {
            for (int i = 0; i < LETTER_LENGTH; i++) {
                if (root.child[i] != null && helper(root.child[i], idx + 1, word)) {
                    return true;
                }
            }
        } else {
            if (root.child[word.charAt(idx) - 'a'] == null || root.child[word.charAt(idx) - 'a'].c != word.charAt(idx)) {
                return false;
            }
            root = root.child[word.charAt(idx) - 'a'];
            return helper(root, idx + 1, word);
        }
        return false;
    }
}
