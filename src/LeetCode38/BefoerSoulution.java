package LeetCode38;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年10月18日
 */
public class BefoerSoulution {

    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "1");
        map.put(2, "11");
        map.put(3, "21");

        map.put(4, "1211");

        for (int i = 5; i <= 30; i++) {
            String str = map.get(i - 1);
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int start = 0;
            int point = 1;
            while (point < str.length()) {
                if (str.charAt(start) != str.charAt(point)) {
                    sb.append(count);
                    sb.append(str.charAt(start));
                    start = point;
                    count = 1;
                } else {
                    count++;
                }
                point++;
            }
            sb.append(count);
            sb.append(str.charAt(start));
            map.put(i, sb.toString());
        }

        System.out.println(map.size());

        System.out.print('{');
        for (String s : map.values()) {
            System.out.print('"' + s + '"' + ", ");
        }
        System.out.print('}');
    }
}
