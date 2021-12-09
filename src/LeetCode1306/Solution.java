package LeetCode1306;

/**
 * @author Chanmoey
 * @date 2021年12月09日 8:13
 * @description
 */
class Solution {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return this.jump(arr, start, visited);
    }

    private boolean jump(int[] arr, int index, boolean[] visited) {
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }

        visited[index] = true;

        return arr[index] == 0 ||
                jump(arr, index - arr[index], visited) ||
                jump(arr, index + arr[index], visited);
    }
}
