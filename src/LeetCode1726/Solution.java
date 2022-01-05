package LeetCode1726;

/**
 * @author Chanmoey
 * @date 2022年01月05日
 */
class Solution {

    public int totalMoney(int n) {
        int seven = 7;
        int weekNumber = n / seven;
        int dayNumber = n % seven;
        int aWeekMoney = 0;
        for (int i = 1; i <= dayNumber; i++) {
            aWeekMoney += i;
        }

        if (n <= 7) {
            return aWeekMoney;
        }

        int firstWeekMoney = 28;
        return weekNumber * firstWeekMoney + aWeekMoney + seven * (weekNumber - 1) + dayNumber;
    }
}
