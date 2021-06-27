package program.learning.leetcode;

/**
 * Created by yanxinming on 2020/7/19
 */
public class Id647 {
    private static int countSubstrings(String s) {

        if (s.length() < 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result++;
            int left = i, right = i;
            while (--left >= 0 && ++right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    result++;
                } else {
                    break;
                }
            }
            left = i;right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    result++;
                } else {
                    break;
                }
                left--;
                right++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String str = "fdsklf";
        System.out.println(countSubstrings(str));

    }
}
