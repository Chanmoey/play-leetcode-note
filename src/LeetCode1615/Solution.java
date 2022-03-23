package LeetCode1615;

/**
 * @author Chanmoey
 * @date 2022年03月23日
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        int[][] graph = new int[n][n];
        for (int[] road:roads){
            count[road[0]]++;
            count[road[1]]++;
            graph[road[0]][road[1]]=1;
            graph[road[1]][road[0]]=1;
        }
        int maxRank = 0;
        for (int i = 0; i <n; i++) {
            for(int j = i+1; j<n; j++) {
                maxRank = Math.max(maxRank, count[i]+count[j]-graph[i][j]);
            }
        }
        return maxRank;
    }
}
