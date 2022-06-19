package LeetCode1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这题一看就可以用Trie字典树解决，但是暴力破解也不失为一个容易想到的方案。
 *
 * @author Chanmoey
 * @date 2022年06月19日
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        StringBuilder pref = new StringBuilder();

        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            pref.append(searchWord.charAt(i));
            List<String> temp = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(pref.toString())) {
                    temp.add(product);
                    if (temp.size() >= 3) {
                        break;
                    }
                }
            }
            res.add(temp);
        }

        return res;
    }
}
