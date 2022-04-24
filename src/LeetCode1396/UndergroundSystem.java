package LeetCode1396;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年04月24日
 */
class UndergroundSystem {

    private final Map<String, List<Integer>> average;
    private final Map<Integer, String> checkIn;

    public UndergroundSystem() {
        this.average = new HashMap<>();
        this.checkIn = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        this.checkIn.put(id, stationName + ' ' + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String[] check = this.checkIn.remove(id).split(" ");
        String startStation = check[0];
        int time = t - Integer.parseInt(check[1]);

        this.average.computeIfAbsent(startStation + "-" + stationName, key -> new ArrayList<>()).add(time);
    }

    public double getAverageTime(String startStation, String endStation) {
        return this.getAverage(this.average.get(startStation + "-" + endStation));
    }

    private double getAverage(List<Integer> list) {

        if (list == null) {
            return 0;
        }

        int sum = 0;
        for (int num : list) {
            sum += num;
        }

        return (double) sum / list.size();
    }
}
