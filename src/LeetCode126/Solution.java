package LeetCode126;

import java.util.*;

/**
 * The solution is from https://github.com/Chanmoey/Play-Leetcode/blob/master/0126-Word-Ladder-II/cpp-0126/main.cpp
 */
class Solution {

    // TODO: fix bug
    /*public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        int end = wordList.indexOf(endWord);

        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        int begin = wordList.indexOf(beginWord);

        int n = wordList.size();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (this.isOneLetterDiffer(wordList.get(i), wordList.get(j))){
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }
        
        Map<Integer, Integer> distance = new HashMap<>();
        this.bfs(g, begin, end, distance);
        
        List<List<String>> res = new ArrayList<>();
        List<Integer> tres = new ArrayList<>();
        tres.add(begin);
        this.getRes(g,begin, end, distance, wordList, tres, res);
        
        return res;
    }

    private void bfs(List<List<Integer>> g, int begin, int end, Map<Integer, Integer> distance) {
        Deque<Integer> q = new ArrayDeque<>();
        q.push(begin);
        distance.put(begin, 0);

        while (!q.isEmpty()) {
            int cur = q.getFirst();
            q.removeFirst();
            for (int j : g.get(cur)) {
                if (distance.containsKey(j)) {
                    distance.put(j, distance.get(cur) + 1);
                    q.addLast(j);
                }
            }
        }
    }

    private void getRes(List<List<Integer>> g, int cur, int end,
                        Map<Integer, Integer> distance,
                        List<String> wordList,
                        List<Integer> tres, List<List<String>> res) {

        if (!tres.isEmpty() && tres.get(tres.size() - 1).equals(end)) {
            res.add(this.getPath(tres, wordList));
            return;
        }

        for (int i : g.get(cur)) {
            if (distance.get(i).equals(distance.get(cur) + 1)) {
                tres.add(i);
                getRes(g, i, end, distance, wordList, tres, res);
                tres.remove(tres.size() - 1);
            }
        }

        return;
    }

    private List<String> getPath(List<Integer> path, List<String> wordList) {
        List<String> ret = new ArrayList<>();
        for (int e : path) {
            ret.add(wordList.get(e));
        }
        return ret;
    }

    private boolean isOneLetterDiffer(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int differ = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (chars1[i] != chars2[i]) {
                differ++;
                if (differ > 1) {
                    return false;
                }
            }
        }

        return true;
    }*/
}
