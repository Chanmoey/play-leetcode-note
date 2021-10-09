package LeetCode212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 使用Trie数据结构
 */
class Solution {

    class Node {
        Node[] next;
        boolean end = false;

        public Node() {
            this.next = new Node[26];
        }
    }

    Node root = null;

    final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int R, C, maxLen = 0;

    public List<String> findWords(char[][] board, String[] words) {

        root = new Node();
        R = board.length;
        C = board[0].length;
        Set<String> set = new HashSet<>();

        for (String word : words) {
            this.insert(word);
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                boolean[][] visited = new boolean[R][C];
                Node cur = root;
                String s = "";
                this.searchWord(board, i, j, cur, s, visited, set);
            }
        }

        return new ArrayList<>(set);
    }

    private void searchWord(char[][] board, int x, int y,
                            Node cur, String s,
                            boolean[][] visited, Set<String> set) {
        if (cur.next[board[x][y] - 'a'] == null) {
            return;
        }

        s += board[x][y];
        if (s.length() > maxLen) {
            return;
        }

        cur = cur.next[board[x][y] - 'a'];
        if (cur.end) {
            set.add(s);
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (this.inArea(newX, newY) && !visited[newX][newY])
                searchWord(board, newX, newY, cur, s, visited, set);
        }
        visited[x][y] = false;
        s = s.substring(0, s.length() - 1);
    }

    private void insert(String word) {

        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new Node();
            cur = cur.next[c - 'a'];
        }

        cur.end = true;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
