package LeetCode386;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 通过Java自带的字符串排序来完成。但显而易见，要创建大量的中间对象和多次的类型转换。效率不高，但是实现简单。
 *
 * @author Chanmoey
 * @date 2022年01月23日
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> stringList = new ArrayList<>(n);
        List<Integer> integerList = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            stringList.add(String.valueOf(i));
        }

        Collections.sort(stringList);
        for (String s : stringList) {
            integerList.add(Integer.valueOf(s));
        }

        return integerList;
    }
}