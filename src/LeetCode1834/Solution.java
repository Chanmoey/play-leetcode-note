package LeetCode1834;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * @author Chanmoey
 * @date 2022年12月29日
 */
class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> enqueueTime = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> processTime = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            } else {
                return a[1] - b[1];
            }
        });

        int[][] myTask = new int[tasks.length][3];

        // 添加序号
        Stream.iterate(0, i -> i + 1).limit(tasks.length).forEach(i1 -> {
            System.arraycopy(tasks[i1], 0, myTask[i1], 0, tasks[i1].length);
            myTask[i1][2] = i1;
        });
        enqueueTime.addAll(Arrays.asList(myTask));

        int[] res = new int[tasks.length];
        int index = 0;
        int curTime = 0;
        while (!enqueueTime.isEmpty()) {
            int[] curTask;
            if (!processTime.isEmpty()) {
                curTask = processTime.poll();
                res[index++] = curTask[2];
                curTime += curTask[1];
            }
            while (!enqueueTime.isEmpty()) {
                int[] peek = enqueueTime.peek();
                if (peek[0] <= curTime) {
                    processTime.add(enqueueTime.poll());
                } else {
                    break;
                }
            }

            // CPU空闲了一段时间或者执行第一个任务的情况
            if (processTime.isEmpty() && !enqueueTime.isEmpty()) {
                curTask = enqueueTime.poll();
                curTime = curTask[0] + curTask[1];
                res[index++] = curTask[2];
            }
        }

        while (!processTime.isEmpty()) {
            int[] curTask = processTime.poll();
            res[index++] = curTask[2];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
    }
}
