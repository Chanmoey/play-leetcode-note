package LeetCode458;

/**
 * @author Chanmoey
 * @date 2022年08月06日
 */
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log((float) minutesToTest / minutesToDie + 1));
    }
}
