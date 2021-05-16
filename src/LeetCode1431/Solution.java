package LeetCode1431;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = max(candies);
        for(int i = 0; i < candies.length; i++){
            if((candies[i] - max + extraCandies) >= 0){
                list.add(true);
            }
            else {
                list.add(false);
            }
        }

        return list;
    }

    int max(int[] arr){
        int max = 0;
        for(int item: arr){
            if(item > max){
                max = item;
            }
        }

        return max;
    }
}