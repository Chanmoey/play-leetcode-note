package LeetCode745;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年06月18日
 */

class TrieNode {
    public final List<Integer> indexes;
    private final TrieNode[] children;
    private final boolean isEnd;

    public TrieNode() {
        this.indexes = new ArrayList<>();
        this.children = new TrieNode[26];
        Arrays.fill(this.children, null);
        this.isEnd = false;
    }

    public TrieNode getChild(char c) {
        return this.children[c - 'a'];
    }

    public void setChildIfAbsent(char c, TrieNode node) {
        if (!contains(c)) {
            this.children[c - 'a'] = node;
        }
    }

    public boolean contains(char c) {
        return this.children[c - 'a'] != null;
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}

class Trie {
    private final TrieNode rootForward;
    private final TrieNode rootReverse;

    public Trie() {
        this.rootForward = new TrieNode();
        this.rootReverse = new TrieNode();
    }

    public void insert(String word, int index) {
        int n = word.length();
        TrieNode tnf = this.rootForward;
        TrieNode tnr = this.rootReverse;

        for (int i = 0; i < n; i++) {
            char c1 = word.charAt(i);
            char c2 = word.charAt(n - i - 1);

            // 正向Trie
            tnf.setChildIfAbsent(c1, new TrieNode());
            tnf = tnf.getChild(c1);
            tnf.indexes.add(index);

            // 反向Trie
            tnr.setChildIfAbsent(c2, new TrieNode());
            tnr = tnr.getChild(c2);
            tnr.indexes.add(index);
        }
    }

    public int find(String prefix, String suffix) {
        List<Integer> preIdx = this.findPrefix(prefix, this.rootForward);
        List<Integer> sufIdx = findPrefix(new StringBuilder(suffix).reverse().toString(), this.rootReverse);

        int i = preIdx.size() - 1;
        int j = sufIdx.size() - 1;

        if (i == 0 && j >= 10000) {
            return preIdx.get(0);
        }

        while (i >= 0 && j >= 0) {
            if (preIdx.get(i).equals(sufIdx.get(j))) {
                return preIdx.get(i);
            } else if (preIdx.get(i) > sufIdx.get(j)) {
                i--;
            } else {
                j--;
            }
        }

        return -1;
    }

    public List<Integer> findPrefix(String pre, TrieNode root) {
        int n = pre.length();
        TrieNode temp = root;
        for (int i = 0; i < n; i++) {
            char c = pre.charAt(i);
            if (!temp.contains(c)) {
                return new ArrayList<>();
            }
            temp = temp.getChild(c);
        }

        return temp.indexes;
    }
}

class WordFilter {

    private final Trie trie;

    public WordFilter(String[] words) {
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
    }

    public int f(String prefix, String suffix) {
        return trie.find(prefix, suffix);
    }
}
