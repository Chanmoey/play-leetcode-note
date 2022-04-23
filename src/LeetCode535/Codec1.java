package LeetCode535;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年04月23日
 */
public class Codec1 {

    private Map<String, String> map = new HashMap<>();

    public String encode(String longUrl) {
        this.map.put(longUrl, longUrl);
        return longUrl;
    }

    public String decode(String shortUrl) {
        return this.map.get(shortUrl);
    }
}
