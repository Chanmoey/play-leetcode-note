package LeetCode438;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res =  new ArrayList<>();

        if(s.length() < p.length()){
            return res;
        }

        int[] pFreq = new int[26];
        for(int i = 0; i < p.length(); i++){
            pFreq[p.charAt(i) - 'a'] ++;
        }

        int[] sFreq = new int[26];

        int l = 0, r = -1;
        while (r + 1 < s.length()){
            r ++;
            sFreq[s.charAt(r) - 'a'] ++;
            if (r - l + 1 > p.length()){
                sFreq[s.charAt(l++) - 'a'] --;
            }

            if (r - l + 1 == p.length() && same(sFreq, pFreq)){
                res.add(l);
            }
        }
        return res;
    }

    private boolean same(int[] sFreq, int[] pFreq){
        for(int i = 0; i < 26; i++){
            if (sFreq[i] != pFreq[i]){
                return false;
            }
        }

        return true;
    }
}