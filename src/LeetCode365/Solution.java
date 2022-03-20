package LeetCode365;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年03月20日
 */
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }

        if (jug1Capacity == 0) {
            return jug2Capacity == targetCapacity || targetCapacity == 0;
        } else if (jug2Capacity == 0) {
            return jug1Capacity == targetCapacity || targetCapacity == 0;
        }

        if (jug1Capacity > jug2Capacity) {
            return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
        }

        return targetCapacity % gcd(jug2Capacity, jug1Capacity) == 0;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
