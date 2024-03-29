package LeetCode3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;

        while(l < s.length()){
            if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0){
                freq[s.charAt(++r)] ++;
            }
            else{
                freq[s.charAt(l++)] --;
            }
            // 可以把这个提取到else代码块里，节省比较次数。
            res = Math.max(res, r-l+1);
        }

        return res;
    }
}