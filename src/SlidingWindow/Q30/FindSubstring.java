package SlidingWindow.Q30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 车一晗
 * @Date 2022/06/16
 **/
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        Map<String, Integer> need = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();
        for (String word : words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }

        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            int valid = 0;
            window = new HashMap<>();

            while ((right + len) <= s.length()) {
                String sub = s.substring(right, right + len);
                right += len;
                window.put(sub, window.getOrDefault(sub, 0) + 1);
                valid++;
                while (window.getOrDefault(sub, 0) > need.getOrDefault(sub, 0)) {
                    String sub2 = s.substring(left, left + len);
                    left += len;
                    valid--;
                    window.put(sub2, window.get(sub2) - 1);
                }
                if (valid == words.length) {
                    res.add(left);
                }
            }
        }
        return res;
    }
}
