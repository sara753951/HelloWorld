package learning.aboutRegex;

/**
 * Created by yanxinming on 2018/11/6
 */
public class replaceTest {

    public static void main(String[] args) {
        String str = "565720823@qq.com ";
        System.out.println(str.trim());

        String string = "bcjs<float>abc";
        String regex = "(\\<(number_?\\d+d|float)>)|\\d+";
        String replacement = " ";
        String result = replace(string, regex, replacement);
        System.out.println(result);
    }

    private static String replace(String string, String regex, String replacement) {
        String result = string.replaceAll("<(number_?\\d+d|float|num_xxx)>|\\d+", replacement);
        return result;
    }
}
