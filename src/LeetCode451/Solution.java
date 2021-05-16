package LeetCode451;/*

Runtime: 24 ms, faster than 17.17% of Java online submissions for Sort Characters By Frequency.
Memory Usage: 40.3 MB, less than 35.72% of Java online submissions for Sort Characters By Frequency.

import java.util.*;

class Solution {
    public String frequencySort(String s) {

        if (s.equals(""))
            return s;

        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        //这里将map.entrySet()转换成list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        //然后通过比较器来实现排序
        //升序排序
        list.sort(Map.Entry.comparingByValue());

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> mapping:list){
            for(int i = 0; i < mapping.getValue(); i ++){
                sb.append(mapping.getKey());
            }
        }
        return sb.reverse().toString();
    }
}*/

import java.util.ArrayList;
import java.util.Collections;


/// Sorting
/// Time Complexity: O(nlogn)
/// Space Complexity: O(256)
class Solution {

    private class Pair implements Comparable<Pair>{

        public char c;
        public int f;

        public Pair(char c, int f){
            this.c = c;
            this.f = f;
        }

        @Override
        public int compareTo(Pair another){
            return another.f - this.f;
        }
    }

    public String frequencySort(String s) {

        int[] freq = new int[256];
        for(char c: s.toCharArray())
            freq[c] ++;

        ArrayList<Pair> lst = new ArrayList<>();
        for(char c = 0; c < 256; c ++)
            if(freq[c] != 0)
                lst.add(new Pair(c, freq[c]));

        Collections.sort(lst);

        StringBuilder sb = new StringBuilder();
        for(Pair p: lst)
            for(int i = 0; i < p.f; i ++) sb.append(p.c);
        return sb.toString();
    }
}

