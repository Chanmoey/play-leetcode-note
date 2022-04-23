package LeetCode535;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年04月23日
 */
public class Codec {

    private Map<String, String> map = new HashMap<>();

    public String encode(String longUrl) {
        String hashcode = String.valueOf(longUrl.hashCode());
        this.map.put(hashcode, longUrl);
        return hashcode;
    }

    public String decode(String shortUrl) {
        return this.map.get(shortUrl);
    }
}
