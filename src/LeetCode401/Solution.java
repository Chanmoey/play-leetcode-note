package LeetCode401;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        boolean[] bits = new boolean[10];
        go(bits, 0, turnedOn, res);
        return res;
    }

    private void go(boolean[] bits, int index, int num, List<String> res){

        if (index == 10) {
            int h = 0;
            for (int i = 0; i < 4; i ++) {
                h = h * 2 + (bits[i] ? 1 : 0);
            }

            int m = 0;
            for (int i = 4; i < 10; i++) {
                m = m * 2 + (bits[i] ? 1 : 0);
            }

            if (h < 12 && m < 60) {
                StringBuilder sb = new StringBuilder();
                sb.append(h).append(":");
                if (m < 10) {
                    sb.append("0").append(m);
                }
                else {
                    sb.append(m);
                }
                res.add(sb.toString());
            }
        }

        if (10 - index > num) {
            this.go(bits, index + 1, num, res);
        }

        if (num > 0) {
            bits[index] = true;
            this.go(bits, index + 1, num - 1, res);
            bits[index] = false;
        }
    }
}