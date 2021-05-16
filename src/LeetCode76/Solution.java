package LeetCode76;

class Solution {
    public String minWindow(String s, String t) {
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];
        for(int i = 0; i < t.length(); i++){
            tFreq[t.charAt(i)] ++;
        }

        int l = 0, r = -1;
        int sCnt = 0;
        int minLength = s.length() + 1;
        int startIndex = -1;

        while(l < s.length()){

            if (r+1 < s.length() && sCnt < t.length()){
                sFreq[s.charAt(r+1)] ++;
                if (sFreq[s.charAt(r+1)] <= tFreq[s.charAt(r+1)]){
                    sCnt++;
                }
                r++;
            }

            else {
                assert sCnt <= t.length();

                if (sCnt == t.length() && r - l + 1 < minLength){
                    minLength = r - l + 1;
                    startIndex = l;
                }

                sFreq[s.charAt(l)] --;
                if (sFreq[s.charAt(l)] < tFreq[s.charAt(l)]){
                    sCnt--;
                }
                l++;
            }
        }

        if (startIndex != -1){
            return s.substring(startIndex, startIndex+minLength);
        }

        return "";

    }
}