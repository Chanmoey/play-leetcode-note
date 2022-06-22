package LeetCode831;

import java.util.Locale;

/**
 * @author Chanmoey
 * @date 2022年06月22日
 */
class Solution {
    private static final String ZERO_COUNTRY_CODE = "***-***-";
    private static final String ONE_COUNTRY_CODE = "+*-***-***-";
    private static final String TWO_COUNTRY_CODE = "+**-***-***-";
    private static final String THREE_COUNTRY_CODE = "+***-***-***-";

    public String maskPII(String s) {
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhoneNumber(s);
        }
    }

    private String maskEmail(String s) {
        s = s.toLowerCase(Locale.ROOT);
        String[] email = s.split("@");
        return email[0].charAt(0) + "*****" + email[0].charAt(email[0].length() - 1) + "@" + email[1];
    }

    private String maskPhoneNumber(String s) {
        s = this.extractNumber(s);
        String substring = s.substring(s.length() - 4);
        switch (s.length()) {
            case 10 -> {
                return ZERO_COUNTRY_CODE + substring;
            }
            case 11 -> {
                return ONE_COUNTRY_CODE + substring;
            }
            case 12 -> {
                return TWO_COUNTRY_CODE + substring;
            }
            case 13 -> {
                return THREE_COUNTRY_CODE + substring;
            }

            default ->
                throw new IllegalArgumentException("NO NORMAL PHONE NUMBER");

        }
    }

    private String extractNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}