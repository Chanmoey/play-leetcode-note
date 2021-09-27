package LeetCode929;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] strings = email.split("@");
            char[] chars = strings[0].toCharArray();

            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                if (aChar == '.') {
                    continue;
                }
                if (aChar == '+') {
                    break;
                }
                sb.append(aChar);
            }
            sb.append('@').append(strings[1]);
            set.add(sb.toString());
        }

        return set.size();
    }
}
