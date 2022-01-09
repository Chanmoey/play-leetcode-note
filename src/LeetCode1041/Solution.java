package LeetCode1041;

/**
 * @author Chanmoey
 * @date 2022年01月09日
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        char currentDir = 'N';
        char initialDir = 'N';
        int x = 0, y = 0;

        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'G') {
                y += currentDir == 'N' ? 1 : 0;
                y += currentDir == 'S' ? -1 : 0;
                x += currentDir == 'E' ? 1 : 0;
                x += currentDir == 'W' ? -1 : 0;
            } else {
                char incoming = instructions.charAt(i);
                if (currentDir == 'N') {
                    currentDir = incoming == 'L' ? 'W' : 'E';
                } else if (currentDir == 'W') {
                    currentDir = incoming == 'L' ? 'S' : 'N';
                } else if (currentDir == 'S') {
                    currentDir = incoming == 'L' ? 'E' : 'W';
                } else {
                    currentDir = incoming == 'L' ? 'N' : 'S';
                }
            }

        }
        return originVerifier(x, y) || currentDir != initialDir;
    }

    private boolean originVerifier(int x, int y) {
        return x == 0 && y == 0;
    }
}
