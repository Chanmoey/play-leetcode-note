package LeetCode605;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean isEmpty = true;
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (isEmpty) {
                if (i + 1 >= flowerbed.length) {
                    if (flowerbed[i] == 0) {
                        res++;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                        res++;
                        flowerbed[i] = 1;
                    }
                }
            }

            isEmpty = flowerbed[i] != 1;
        }

        return res >= n;
    }
}
