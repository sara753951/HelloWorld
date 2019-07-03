package learning.aboutRegex;

/**
 * Created by yanxinming on 2018/11/6
 */
public class replaceTest {

    public static void main(String[] args) {

        System.out.println("1234567".matches("\\d+"));
        System.out.println("sfa1234567".matches("\\d+"));
        System.out.println("1234dsa567".matches("\\d+"));

        String str = "\"{\"name\":\"123\"}\"\"{\"name\":\"123\"}\"\n" +
                "\"{\n" +
                "  \"infoListSize\":35,\n" +
                "  \"sectionMap\":\"{\n" +
                "    \"教育经历\":\"[34,35]\",\n" +
                "    \"自我评价\":\"[15,16]\",\n" +
                "    \"工作经历\":[17,33],\n" +
                "    \"个人信息\":[0,7],\n" +
                "    \"求职意向\":[8,14]\n" +
                "  \"}\"\n" +
                "\n" +
                "}\"";
//        String regex = "\"(?=[{\\[])|(?<=[}\\]])\"";
        System.out.println(str.replaceAll("\"(?=[{\\[])|(?<=[}\\]])\"", ""));


//        String str = "565720823@qq.com ";
//        System.out.println(str.trim());
//
//        String string = "bcjs<float>abc";
//        String regex = "(\\<(number_?\\d+d|float)>)|\\d+";
//        String replacement = " ";
//        String result = replace(string, regex, replacement);
//        System.out.println(result);
    }

    private static String myReplace(String string, String regex, String replacement) {
        String result = string.replaceAll(regex, replacement);
        return result;
    }

    private static String replace(String string, String regex, String replacement) {
        String result = string.replaceAll("<(number_?\\d+d|float|num_xxx)>|\\d+", replacement);
        return result;
    }
}
