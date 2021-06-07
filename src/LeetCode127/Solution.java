package LeetCode127;

import java.util.*;

/*
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean hasEnd = false;
        for (String s : wordList) {
            if (s.equals(endWord)) {
                hasEnd = true;
                break;
            }
        }

        if (!hasEnd) {
            return 0;
        }

        Deque<Pair<String, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair<>(beginWord, 1));

        boolean[] visited = new boolean[wordList.size() + 1];
        visited[wordList.size()] = true;
        while (!q.isEmpty()) {
            String curStr = q.getFirst().getKey();
            int step = q.getFirst().getValue();
            q.removeFirst();

            if (this.isOneLetterDiffer(curStr, endWord)) {
                return step + 1;
            }

            for (int i = 0; i < wordList.size(); i++) {
                String next = wordList.get(i);
                if (!visited[i]) {
                    if (this.isOneLetterDiffer(curStr, next)) {
                        q.addLast(new Pair<>(next, step + 1));
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }

    private boolean isOneLetterDiffer(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int differ = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (chars1[i] != chars2[i]) {
                differ++;
            }
        }

        return differ == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        if (s.isOneLetterDiffer("a", "b")) {
            System.out.println("相差是一位");
        } else {
            System.out.println("相差不是一位");
        }
    }
}
