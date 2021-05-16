package LeetCode205;/*import java.util.Arrays;
Runtime: 3 ms, faster than 97.42% of Java online submissions for Isomorphic Strings.
Memory Usage: 39.3 MB, less than 27.53% of Java online submissions for Isomorphic Strings.
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] map = new int[256];
        Arrays.fill(map, -1);

        boolean[] mapped = new boolean[256];
        Arrays.fill(mapped, false);

        for(int i = 0; i < s.length(); i ++){

            if(map[s.charAt(i)] == -1){

                if(mapped[t.charAt(i)]){
                    return false;
                }

                map[s.charAt(i)] = t.charAt(i);
                mapped[t.charAt(i)] = true;
            }
            else if(map[s.charAt(i)] != t.charAt(i)){
                return false;
            }
        }

        return true;
    }
}*/


//Runtime: 6 ms, faster than 76.36% of Java online submissions for Isomorphic Strings.
//Memory Usage: 39.1 MB, less than 62.33% of Java online submissions for Isomorphic Strings.
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), -1);
        }

        HashMap<Character, Boolean> tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), false);
        }

        for(int i = 0; i < s.length(); i++){
            if (sMap.get(s.charAt(i)) == -1){
                if (tMap.get(t.charAt(i))){
                    return false;
                }

                sMap.put(s.charAt(i), (int) t.charAt(i));
                tMap.put(t.charAt(i), true);
            }
            else if(sMap.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
