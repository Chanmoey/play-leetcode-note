package LeetCode383;

class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();

        int index = 0;
        while (index < r.length || index < m.length) {
            if (index < r.length) {
                ++table[r[index] - 'a'];
            }

            if (index < m.length) {
                --table[m[index] - 'a'];
            }

            ++index;
        }
        for (int i : table) {
            if (i > 0) {
                return false;
            }
        }

        return true;
    }
}