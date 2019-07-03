package leetcode;

/**
 * Created by yanxinming on 2019/2/14
 */
public class id6 {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 1 || numRows < 1) {
            return "";
        }
        if (numRows == 1) {
            return  s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[Math.min(numRows, s.length())];
        int index = 0;
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            stringBuilders[index] = (stringBuilders[index] == null ? new StringBuilder() : stringBuilders[index]);
            stringBuilders[index].append(s.charAt(i));
            if (index == 0) {
                direction = 1;
            } else if (index == numRows - 1) {
                direction = -1;
            }
            index += direction;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("A", 2));
    }
}
