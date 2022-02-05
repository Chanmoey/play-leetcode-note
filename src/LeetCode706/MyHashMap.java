package LeetCode706;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 直接复用HashMap
 *
 * @author Chanmoey
 * @date 2022年02月05日
 */
class MyHashMap {

    private Map<Integer, Integer> map;

    public MyHashMap() {
        this.map = new HashMap<>();
    }

    public void put(int key, int value) {
        this.map.put(key, value);
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            return this.map.get(key);
        }
        return  -1;
    }

    public void remove(int key) {
        this.map.remove(key);
    }
}
