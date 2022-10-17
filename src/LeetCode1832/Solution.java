package LeetCode1832;

/**
 * @author Chanmoey
 * @date 2022年10月17日
 */
class Solution {

    private static class Map {
        int[] arr = new int[26];
        int size = 0;


        public void add(char c) {
            if (arr[c - 'a'] == 0) {
                size++;
            }
            arr[c - 'a']++;
        }

        public int getSize() {
            return size;
        }
    }

    public boolean checkIfPangram(String sentence) {

        Map map = new Map();

        for (char c : sentence.toCharArray()) {
            map.add(c);
        }

        return map.getSize() == 26;
    }
}
