import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanxinming on 2018/9/7
 */
public class regexLearning {

    public static void main(String[] args) {

        String line = "(demonstrative)(keywords)(question)";
        String reg = "(?<=\\()(\\w+)(?=\\))";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
        }

        String regNum = "\\D+(\\d+)$";    //提取字符串末尾的数字：封妖塔守卫71 == >> 71
        String s = "路何方ljm: 顾客 路何方ljm 加入咨询 商品11111编号：1293744";
        Pattern p2 = Pattern.compile(regNum);
        Matcher m2 = p2.matcher(s);
        if(m2.find()){
            System.out.println(m2.groupCount());
            System.out.println(m2.group(1));  // 组提取字符串
        }

        String str = "y@jd.com";
        System.out.println(isMatch(str));
    }

    private static boolean isMatch(String str) {

        String regex = "^\\d?[a-zA-Z0-9]@[a-zA-Z]{1,10}.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean re = matcher.matches();

        return re;
    }
}
