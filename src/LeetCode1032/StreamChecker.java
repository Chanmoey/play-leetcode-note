package LeetCode1032;

/**
 * @author Chanmoey
 * @date 2021年12月04日 16:09
 * @description
 */
class StreamChecker {

    private final String[] words;
    private final String lastChar;
    private String suffix;

    public StreamChecker(String[] words) {
        this.words = words;
        this.suffix = "";
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.charAt(word.length() - 1));
        }
        this.lastChar = sb.toString();
    }

    public boolean query(char letter) {
        this.suffix += letter;

        if (this.lastChar.contains(String.valueOf(letter))) {
            for (String word : words) {

                if (suffix.length() >= word.length()) {
                    int i = word.length() - 1;
                    int j = this.suffix.length() - 1;

                    for (; i >= 0; i--, j--) {
                        if (this.suffix.charAt(j) != word.charAt(i)) {
                            break;
                        }
                    }

                    if (i < 0) {
                        return true;
                    }
                }

            }
        }

        return false;
    }
}

