package LeetCode5;

class Solution1 {
    public String longestPalindrome(String s) {

        if ("".equals(s)) {
            return s;
        }

        int n = s.length();
        String res = s.substring(0, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + res.length(); j < n; j++) {
                if (this.isPalindrome(s, i, j) && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int a, int b) {

        while (a <= b) {
            if (s.charAt(a++) != s.charAt(b--)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "cbbd";

        Solution1 solu = new Solution1();
        String r = solu.longestPalindrome(s);
        System.out.println(r);
//        boolean b = solu.isPalindrome(s, 0, 0);
//        System.out.println(b);
    }
}
