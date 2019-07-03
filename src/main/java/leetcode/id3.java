package leetcode;

/**
 * Created by yanxinming on 2019/2/6
 */
public class id3 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int max = 0;
        StringBuilder sbSubString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (sbSubString.indexOf(s.charAt(i) + "") != -1) {
                sbSubString.replace(0, sbSubString.indexOf(s.charAt(i) + ""), "");
            }
            sbSubString.append(s.charAt(i));
            if (max < sbSubString.length()) {
                max = sbSubString.length();
            }
        }
        return max;
    }
}
