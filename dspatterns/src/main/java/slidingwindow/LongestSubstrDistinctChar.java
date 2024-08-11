package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstrDistinctChar {
    // s1 = "abacabcbb"
    public static String findLongestSubstringWithDistinctChar(String s) {
        if (s == null || s.length() == 1 || s.isEmpty()) {
            return s;
        }
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0;
        String distinctChar = "";
        for (int i = 0; i < s.length(); i++) {
            Integer index = charIndexMap.getOrDefault(s.charAt(i), -1);
            if (index == -1) {
                charIndexMap.put(s.charAt(i), i);
            } else {
                String subStr = s.substring(start, i);
                distinctChar = (distinctChar.length() < subStr.length()) ? subStr : distinctChar;
                start = index;
                charIndexMap.put(s.charAt(i), i);
            }

        }
        return distinctChar;
    }

    public static void main(String[] args) {
        String distinctChar = findLongestSubstringWithDistinctChar("abacabcbb");
        System.out.println(distinctChar);
    }
}
