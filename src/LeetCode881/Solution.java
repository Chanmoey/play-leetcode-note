package LeetCode881;

import java.util.*;

/**
 * TLE
 *
 * @author Chanmoey
 * @date 2022年03月24日
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        List<Integer> person = new ArrayList<>();
        for (int j : people) {
            person.add(j);
        }
        person.sort((a, b) -> b - a);

        int step = 0;
        while (person.size() > 0) {
            int head = person.get(0);
            if (head >= limit) {
                step ++;
                person.remove(0);
            } else{
                int size = person.size();
                int i = 1;
                for (; i < person.size(); i++) {
                    if (head + person.get(i) <= limit) {
                        step ++;
                        person.remove(i);
                        person.remove(0);
                        break;
                    }
                }
                if (person.size() == size) {
                    step ++;
                    person.remove(0);
                }
            }
        }

        return step;
    }
}
