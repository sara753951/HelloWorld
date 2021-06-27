package program.learning.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanxinming on 2019/2/15
 */
public class Id8 {
    public static int myAtoi(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("(?<=^)[+-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String num = matcher.group(0);
            int number;
            try {
                number = Integer.parseInt(num);
            } catch (NumberFormatException e) {
                if (num.startsWith("-")) {
                    number = Integer.MIN_VALUE;
                } else {
                    number = Integer.MAX_VALUE;
                }
            }
            return number;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("91283472332"));
    }
}
