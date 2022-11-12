package LeetCode295;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 主要是想借助TreeMap的有序性，来降低时间复杂度。但是Time Limit Exceeded。
 *
 * @author Chanmoey
 * @date 2022年11月12日
 */
class MedianFinder1 {

    private static class Pair implements Comparable<Pair> {
        Integer id;
        int num;

        public Pair(Integer id, int num) {
            this.id = id;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {

            // 大坑，TreeSet不是调用equals()判断是否相等，而是看compareTo是不是返回0。
            if (this.num == o.num) {
                return this.id - o.id;
            } else {
                return this.num - o.num;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair other) {
                return this.id.equals(other.id);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    private final Set<Pair> list;

    private static final AtomicInteger idGenerator = new AtomicInteger();

    public MedianFinder1() {
        list = new TreeSet<>();
    }

    public void addNum(int num) {
        Integer id = idGenerator.getAndIncrement();
        list.add(new Pair(id, num));
    }

    //    @SuppressWarnings("all")
    public double findMedian() {
        Object[] arr = list.toArray();
        int index = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (((Pair) arr[index]).num + ((Pair) arr[index - 1]).num) / 2.0;
        } else {
            return ((Pair) arr[index]).num;
        }
    }

    public static void main(String[] args) {
        MedianFinder1 mf = new MedianFinder1();
        mf.addNum(6);
        mf.addNum(10);
        mf.addNum(2);
        mf.addNum(6);
        System.out.println("mf.findMedian() = " + mf.findMedian());
    }
}