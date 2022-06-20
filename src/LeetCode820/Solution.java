package LeetCode820;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年06月20日
 */
class Solution {

    private static class TrieNode {
        TrieNode[] children;
        int childCnt;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private final TrieNode root = new TrieNode();
    private Map<Integer, Integer> map = new HashMap<>();

    private void insert(TrieNode root, String word, int position) {
        if (position == word.length()) {
            return;
        }
        int idx = word.charAt(position) - 'a';
        if (root.children[idx] == null) {
            root.children[idx] = new TrieNode();
            root.childCnt++;
        }
        insert(root.children[idx], word, position + 1);
    }

    private void collect(TrieNode node, int depth) {
        if (node.childCnt == 0) {
            map.put(depth, map.getOrDefault(depth, 0) + 1);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                collect(node.children[i], depth + 1);
            }
        }
    }

    public int minimumLengthEncoding(String[] words) {
        for (String word : words) {
            word = new StringBuilder(word).reverse().toString();
            this.insert(root, word, 0);
        }

        this.collect(root, 0);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += (1 + entry.getKey()) * entry.getValue();
        }

        return res;
    }
}
