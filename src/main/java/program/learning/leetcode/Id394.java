package program.learning.leetcode;

import java.util.Stack;

/**
 * Created by yanxinming on 2020/6/18
 */
public class Id394 {
    private static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder intSB = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                intSB.append(c);
            } else if (c == '[') {
                StringBuilder repeatSB = new StringBuilder();
                Stack<Character> stack = new Stack<>();
                stack.add(s.charAt(i));
                repeatSB.append(s.charAt(i));
                while (!stack.isEmpty()) {
                    char current = s.charAt(++i);
                    if (current == ']') {
                        stack.pop();
                    } else if (current == '[') {
                        stack.push(current);
                    }
                    repeatSB.append(current);
                }

                for (int k = 0; k < Integer.parseInt(intSB.toString()); k++) {
                    sb.append(decodeString(repeatSB.substring(1, repeatSB.length() - 1)));
                }
                intSB = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
