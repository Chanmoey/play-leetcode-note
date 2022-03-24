package LeetCode881;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年03月24日
 */
public class Solution1 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        int step = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i ++;
            }
            j--;
            step++;
        }

        return step;
    }
}
