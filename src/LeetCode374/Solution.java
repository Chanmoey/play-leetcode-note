package LeetCode374;

/**
 * 没什么意义，避免报错而已。
 */
class GuessGame{

}

/**
 * 就一个二分搜索算法的考察罢了。
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {

        if (n <= 1) {
            return 1;
        }
        int top = n;
        int bottom = 1;
        int myGuess = n;

        while (true) {
            if (guess(myGuess) == 1) {
                bottom = myGuess;
                myGuess = bottom + (top - bottom) / 2;
            }

            if (guess((myGuess)) == -1) {
                top = myGuess;
                myGuess = myGuess >> 1;
            }

            if (guess(myGuess) == 0) {
                return myGuess;
            }
        }
    }

    /**
     * LeetCode 提供的API，在这里没什么意义，避免报错而已。
     * @param num
     * @return
     */
    private int guess(int num) {
        return 1;
    }
}
