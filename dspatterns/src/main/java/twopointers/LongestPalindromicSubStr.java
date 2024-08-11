package twopointers;

public class LongestPalindromicSubStr {
    public String getLongestPalindromicSubString(String str) {
        String maxLenString = "";
        for (int i = 0; i < str.length(); i++) {
            String odd = getSubString(str, i, i);
            String even = getSubString(str, i, i + 1);
            String result = (odd.length() > even.length()) ? odd : even;
            if (result.length() > maxLenString.length()) {
                maxLenString = result;
            }
        }
        return maxLenString;
    }

    private String getSubString(String str, int l, int r) {
        while (l >= 0 && r < str.length() && (str.charAt(l) == str.charAt(r))) {
            l--;
            r++;
        }
        return str.substring(l + 1, r);

    }

    public static void main(String[] args) {
        LongestPalindromicSubStr palindromicSubStr = new LongestPalindromicSubStr();
        String string = palindromicSubStr.getLongestPalindromicSubString("cbbd");
        System.out.println(string);

    }
}
