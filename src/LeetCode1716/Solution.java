package LeetCode1716;

/**
 * @author Chanmoey
 * @date 2022年01月05日
 */
class Solution {

    public int totalMoney(int n) {
        int seven = 7;

        int res = 0;
        if (n <= seven) {
            for (int i = 1; i <= n; i++) {
                res += i;
            }
            return res;
        }

        int week = n / seven;
        int day = n % seven;

        int notWeekMoney = 0;
        for (int i = week + 1; i <= week + day; i++) {
            notWeekMoney += i;
        }

        int firstWeekMoney = 28;
        return firstWeekMoney * week + week * (week - 1) * seven / 2 + notWeekMoney;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.totalMoney(20);
    }
}
