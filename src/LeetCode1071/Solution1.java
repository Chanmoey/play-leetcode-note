package LeetCode1071;

/**
 * @author Chanmoey
 * @date 2023年02月02日
 */
class Solution1 {
    public String gcdOfStrings(String str1, String str2) {
        if ("".equals(str1.replaceAll(str2, ""))) {
            return str2;
        }

        int a = str1.length();
        int b = str2.length();
        int div = Math.min(a, b);

        while (div >= 1) {
            if (a % div == 0 && b % div == 0) {
                String divStr = str1.substring(0, div);
                if ("".equals(str1.replaceAll(divStr, "")) && "".equals(str2.replaceAll(divStr, ""))) {
                    return divStr;
                }
            }
            div--;
        }

        return "";
    }
}
