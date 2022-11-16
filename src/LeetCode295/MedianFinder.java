package LeetCode295;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年11月12日
 */
class MedianFinder {

    private final List<Integer> array;

    public MedianFinder() {
        array = new ArrayList<>();
    }

    public void addNum(int num) {
        int i = 0;
        if (!array.isEmpty()) {
            // 插入排序的思想
            while (i < array.size() && array.get(i) < num) {
                i++;
            }
            array.add(i, num);
        } else {
            array.add(num);
        }
    }

    public double findMedian() {
        int index = array.size() / 2;
        if (array.size() % 2 == 0) {
            return (array.get(index) + array.get(index - 1)) / 2.0;
        } else {
            return array.get(index);
        }
    }
}
