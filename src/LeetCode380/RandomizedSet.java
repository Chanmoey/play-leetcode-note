package LeetCode380;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    private HashMap<Integer, Integer> hashSet;
    private ArrayList<Integer> list;
    private Random random;

    public RandomizedSet() {
        this.hashSet = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {

        if (this.hashSet.containsKey(val)) {
            return false;
        }

        this.hashSet.put(val, this.list.size());
        this.list.add(val);
        return true;
    }

    public boolean remove(int val) {

        if (this.hashSet.containsKey(val)) {
            int valIndex = this.hashSet.get(val);
            int lastIndex = this.list.size() - 1;
            this.hashSet.remove(val);
            if (valIndex != lastIndex) {
                Collections.swap(this.list, valIndex, lastIndex);
                this.hashSet.put(this.list.get(valIndex), valIndex);
            }
            this.list.remove(this.list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return this.list.get(this.random.nextInt(this.list.size()));
    }
}
