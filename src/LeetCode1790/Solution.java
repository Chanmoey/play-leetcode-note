package LeetCode1790;

/**
 * @author Chanmoey
 * @date 2022年03月01日
 */
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int noSameNumber = 0;
        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                noSameNumber++;
                if (noSameNumber > 2) {
                    return false;
                }

                if (noSameNumber == 1) {
                    firstIndex = i;
                } else {
                    secondIndex = i;
                }
            }

        }


        return noSameNumber == 0 ||
                (noSameNumber != 1
                        && s1.charAt(firstIndex) == s2.charAt(secondIndex)
                        && s1.charAt(secondIndex) == s2.charAt(firstIndex)
                );

//        if (noSameNumber == 0) {
//            return true;
//        } else {
//            return secondIndex != -1
//                    && s1.charAt(firstIndex) == s2.charAt(secondIndex)
//                    && s1.charAt(secondIndex) == s2.charAt(firstIndex);
//        }
    }
}
