package program.learning.leetcode;

import java.util.HashSet;

/**
 * Created by yanxinming on 2019/2/6
 */
public class Id3 {
    //ac
    private static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int max = 0;
        StringBuilder sbSubString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (sbSubString.indexOf(s.charAt(i) + "") != -1) {
                sbSubString.replace(0, sbSubString.indexOf(s.charAt(i) + "") + 1, "");
            }
            sbSubString.append(s.charAt(i));
            if (max < sbSubString.length()) {
                max = sbSubString.length();
            }
        }
        return max;
    }

    //滑动窗口 ac
    private static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        HashSet<Character> cSet = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (i != 0) {
                cSet.remove(s.charAt(i - 1));
            }
            while (j < s.length()) {
                char c = s.charAt(j);
                if (!cSet.contains(c)) {
                    cSet.add(c);
                } else {
                    break;
                }
                j++;
            }
            max = Math.max(max, cSet.size());
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "";
        System.out.println(lengthOfLongestSubstring2(str));
    }
}
