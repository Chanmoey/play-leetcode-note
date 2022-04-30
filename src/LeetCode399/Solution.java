package LeetCode399;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年04月30日
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] ans = new double[queries.size()];

        Map<String, Map<String, Double>> graph = new HashMap<>(equations.size() * 4);

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.computeIfAbsent(a, k -> new HashMap<>(2)).put(b, values[i]);
            graph.computeIfAbsent(b, k -> new HashMap<>(2)).put(a, 1.0 / values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String c = queries.get(i).get(1);

            if (!graph.containsKey(a) || !graph.containsKey(c)) {
                ans[i] = -1.0;
            } else {
                ans[i] = divide(graph, a, c, new HashSet<>());
            }
        }

        return ans;
    }

    private double divide(Map<String, Map<String, Double>> graph, String a, String c, Set<String> visited) {
        if (a.equals(c)) {
            return 1.0;
        }

        visited.add(a);

        for (String b : graph.get(a).keySet()) {
            if (visited.contains(b)) {
                continue;
            }

            double res = divide(graph, b, c, visited);

            if (res > 0) {
                return graph.get(a).get(b) * res;
            }
        }

        return -1.0;
    }
}
