package LeetCode2279;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年12月27日
 */
public class Solution1 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        long vacancy = 0;
        int res = capacity.length;
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] = capacity[i] - rocks[i];
            vacancy += capacity[i];
        }

        if(vacancy > additionalRocks){
            Arrays.sort(capacity);
            for(int i = 0; i < capacity.length; i++){
                if(additionalRocks < capacity[i]){
                    return i;
                }
                additionalRocks -= capacity[i];
            }
        }
        return res;
    }
}
