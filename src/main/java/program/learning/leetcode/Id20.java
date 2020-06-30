package program.learning.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by yanxinming on 2020/6/16
 */
public class Id20 {
    private static boolean isValid(String s) {

        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put('}','{');
        charMap.put(']','[');
        charMap.put(')','(');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek().equals(charMap.get(s.charAt(i)))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({}))";
        System.out.println(isValid(str));
    }
}
