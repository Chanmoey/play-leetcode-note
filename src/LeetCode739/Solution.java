package LeetCode739;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    temperatures[i] = j - i;
                    break;
                }

                if (j == temperatures.length - 1 && temperatures[j] < temperatures[i]) {
                    temperatures[i] = 0;
                }
            }
        }

        temperatures[temperatures.length - 1] = 0;

        return temperatures;
    }
}
