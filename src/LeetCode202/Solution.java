package LeetCode202;

import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {

        if(n == 1)
            return true;

        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int newN = n;
        while(true){
            newN = squareDigit(newN);
            if (set.contains(newN)){
                return false;
            }
            if (newN == 1){
                return true;
            }

            set.add(newN);
        }
    }

    private int squareDigit(int n){
        int result = 0;
        while (n > 0){
            result = result + (n % 10)*(n % 10);
            n /= 10;
        }

        return result;
    }
}
