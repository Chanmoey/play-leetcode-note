package LeetCode165;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int max = Math.max(str1.length, str2.length);
        int v1, v2;
        for (int i = 0; i < max; i++) {
            v1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]);
            v2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}
