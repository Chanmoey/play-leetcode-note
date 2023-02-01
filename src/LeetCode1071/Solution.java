package LeetCode1071;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2023年02月02日
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if ("".equals(str1.replaceAll(str2, ""))) {
            return str2;
        }

        for (Integer div : getAllGcd(str1.length(), str2.length())) {
            String divStr = str1.substring(0, div);
            if ("".equals(str1.replaceAll(divStr, "")) && "".equals(str2.replaceAll(divStr, ""))) {
                return divStr;
            }
        }

        return "";
    }

    private List<Integer> getAllGcd(Integer a, Integer b) {
        int min = Math.min(a, b);
        List<Integer> res = new ArrayList<>();
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
