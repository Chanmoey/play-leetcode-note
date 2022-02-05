package LeetCode706;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年02月05日
 */
class MyHashMap1 {
    private int[] map = new int[1000001];

    public MyHashMap1() {
    }

    /**
     * 如果value为0，就用-1代替。
     *
     * @param key   key
     * @param value value
     */
    public void put(int key, int value) {
        if (value == 0) {
            value = -1;
        }
        this.map[key] = value;
    }

    /**
     * 如果value为0，则表示没有填充任何值，返回-1。
     * 如果value为-1，则表示填充了0，返回0.
     *
     * @param key key
     * @return value
     */
    public int get(int key) {
        int value = this.map[key];
        if (value == -1) {
            return 0;
        } else if (value == 0) {
            return -1;
        }

        return value;
    }

    public void remove(int key) {
        this.map[key] = 0;
    }
}
