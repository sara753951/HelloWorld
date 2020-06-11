package program.learning.leetcode;

/**
 * Created by yanxinming on 2019/2/13
 */
public class Id5 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }











    public static void main(String[] args) {
        System.out.println(LP("xabcba"));
    }

    public static String LP (String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = start;
        for (int i = 0; i < s.length(); i++) {
            int len1 = centerAround(s, i, i);
            int len2 = centerAround(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int centerAround(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private static String transform(String s) {
        StringBuilder sbT = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sbT.append(s.charAt(i));
        }
        return sbT.toString();
    }
}
