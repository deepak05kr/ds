package twopointers;

public class LongestPalindromicSubstring {
    public String getLongestPalindromicSubsequence(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String oddStr = getString(s, i, i);
            String evenStr = getString(s, i, i + 1);
            String finalStr = (oddStr.length() > evenStr.length()) ? oddStr : evenStr;
            if (result.length() < finalStr.length()) {
                result = finalStr;
            }
        }
        return result;
    }

    private String getString(String s, int left, int right) {
        while (s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public static void main(String args[]) {
        LongestPalindromicSubStr palindromicSubStr = new LongestPalindromicSubStr();
        String result = palindromicSubStr.getLongestPalindromicSubString("BBABCBCAB");
        System.out.println(result);

    }
}
