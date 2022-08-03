package LeetCode729;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author Chanmoey
 * @date 2022年08月03日
 */
class MyCalendar {

    private final TreeSet<Integer> set;
    private final HashMap<Integer, Integer> map;

    public MyCalendar() {
        this.set = new TreeSet<>();
        this.map = new HashMap<>();
    }

    public boolean book(int start, int end) {
        if (map.containsKey(start)) {
            return false;
        }
        Integer floor = set.floor(start);
        if (floor != null && map.get(floor) > start) {
            return false;
        }
        Integer ceil = set.ceiling(start);
        if (ceil != null && ceil < end) {
            return false;
        }

        set.add(start);
        map.put(start, end);

        return true;
    }
}
