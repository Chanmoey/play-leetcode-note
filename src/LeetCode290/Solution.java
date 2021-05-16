package LeetCode290;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");

        if(pattern.length() != strings.length){
            return false;
        }

        HashMap<Character, String> pMap = new HashMap<>();
        for(int i = 0; i < pattern.length(); i ++){
            pMap.put(pattern.charAt(i), "");
        }

        HashMap<String, Boolean> sMap = new HashMap<>();
        for (String string : strings) {
            sMap.put(string, false);
        }

        for(int i = 0; i < pattern.length(); i ++){
            if(pMap.get(pattern.charAt(i)).equals("")){
                if(sMap.get(strings[i])){
                    return false;
                }

                pMap.put(pattern.charAt(i), strings[i]);
                sMap.put(strings[i], true);
            }
            else if (!pMap.get(pattern.charAt(i)).equals(strings[i])){
                return false;
            }
        }

        return true;
    }
}