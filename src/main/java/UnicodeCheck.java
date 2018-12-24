/**
 * Created by yanxinming on 2018/11/5
 */
public class UnicodeCheck {



    public static void main(String[] args) {
        String s = " ";
        String s2 = " ";
        System.out.println(stringToUnicode(s));
        System.out.println(stringToUnicode(s2));
        System.out.println(s.equals(s2));
    }

    public static String stringToUnicode(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            if (ch > 255)
                str += s.charAt(i) + ": " + "\\u" + Integer.toHexString(ch)
                        + "\n";
            else
                str += s.charAt(i) + ": " + "\\u00" + Integer.toHexString(ch)
                        + "\n";
        }
        return str;
    }

    public static String test(){
        return "abc";
    }
}
