package program.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yanxinming on 2018/9/11
 */
public class SomeTest {

    public static void main(String[] args) {

        System.out.println(new Date());
        List<Integer> types = new ArrayList<>();
        types.add(1);
//        types.add(2);
        System.out.println(types.toString().replace("[","").replace("]",""));

//        String str = "<p>咱们是有<strong><span style=\"color: rgb(255, 0, 0);\">30</span></strong>天降价补差服务的哦\n" +
//                "申请方法：\n" +
//                "方法1：打开【京东app】-【客户服务】-【价格保护】进行申请\n" +
//                "方法2：请您选购同款商品重新提交一样的新订单（无需支付）确认新旧订单有差价后，留存截图，提供给京东在线客服\n" +
//                "注：超过时效、订单有赠品无法申请价保等情况无法申请价保，详细价保规则戳这里了解。</p>";
//        System.out.println(str.replaceAll("\\s*","").matches(".*(人工|客服|机器人|智能客服|小智|客服助手).*"));

//        HashMap<String, List<String>> hhh = new HashMap<>();
//        List<String> h = new ArrayList<>();
//        h.add("niacus");
//        hhh.put("cds",h);
//        System.out.println(hhh);


//        HashMap<String, Integer> officialHits = new HashMap<>();
//        officialHits.put("cds",13);
//        System.out.println(officialHits);


//        String str = "678,694,695,696,707,708,709,712,714,723,725,982,983,984,986,999,1000,1001,1002,1008,1009,1010,1012,1013,1014,1015,1016,1017,1018,1019,1020,1021,1022,1023,1024,1025,1026,1046,1051,1058,1083,1084,1085,1126,1144,1175,1176,1177,1178";
//        String str = "";
//        String[] strArray = str.split(",");
//        System.out.println(strArray[0]);

//        System.out.println(Math.pow(10, 0 - 1));
//
//        System.out.println("csvdcz".matches(".*[a-zA-Z].*"));

//        List<Integer> array = new ArrayList<>();
//        array.add(1);
//        array.add(2);
//        array.add(3);
//        array.add(4);
//        array.add(5);
//        array.add(6);
//        String str = array.subList(2,7).toString().replace("[","").replace("]","");
//        System.out.println(str);


//        String string = "qaz";
//        StringBuilder sb = new StringBuilder(string);
//        doSomeTh(sb);
//        string = sb.toString();
//        System.out.println(string);
//
//        System.out.println(getTimeLineLeftStr("###2016 年 -‐ 至今        深圳奥思数据科技有限公司               CTO ###2017 年 -‐ 至今      西安交通大学研究生院       外聘专家 ","2016 年","今"));
//
//
//
//        String s1 = "R32冷媒：R32冷媒为全新冷媒，其主要特点为能有效提高产品的能源效率及制冷制热量指标，同时不会对地球造成任何污染的冷媒，目前日本大部份空调已采用R32冷媒~";
//        String s2 = "R32冷媒：R32冷媒为全新冷媒，其主要特点为能有效提高产品的能源效率及制冷制热量指标";
//
////        s1 = "abcd";
////        s2 = "abcd";
//
//        System.out.println(new SomeTest().similar(s1, s2));
//
//
//        String s = "Hello my world life";
//        s = s.replaceAll("[^\\S]","");
//        System.out.println(s);
//
//
//        String str = " 请问下 现在 下单购买    大概什么时候负责安装？";
//        str = str.replaceAll("\\p{P}","").trim();
//        str = str.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5\\s]+","").trim();
//        System.out.println(str);
    }

    private static void doSomeTh(StringBuilder s1) {
        s1.append("zaq");
    }

    public int editDistance(String str1, String str2) {
        int d[][]; // 矩阵
        int y = str1.length();
        int x = str2.length();
        char ch1; // str1的
        char ch2; // str2的
        int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (y == 0) {
            return x;
        }
        if (x == 0) {
            return y;
        }
        d = new int[y + 1][x + 1]; // 计算编辑距离二维数组
        for (int j = 0; j <= x; j++) { // 初始化编辑距离二维数组第一行
            d[0][j] = j;
        }
        for (int i = 0; i <= y; i++) { // 初始化编辑距离二维数组第一列
            d[i][0] = i;
        }
        for (int i = 1; i <= y; i++) { // 遍历str1
            ch1 = str1.charAt(i - 1);
            // 去匹配str2
            for (int j = 1; j <= x; j++) {
                ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[y][x];
    }

    public int min(int one, int two, int three) {
        int min = one;
        if (two < min) {
            min = two;
        }
        if (three < min) {
            min = three;
        }
        return min;
    }

    public double similar(String str1, String str2) {
        int ed = editDistance(str1, str2);
        System.out.println("ed: " + ed);
        return 1 - (double) ed / Math.max(str1.length(), str2.length());
    }

    public static String getTimeLineLeftStr(String line, String startTime, String endTime) {


        String[] lineSplit = line.split("###");
        for(String seg : lineSplit) {
            if(seg.indexOf(endTime)>=0) {
                String leftStr = seg.substring(seg.indexOf(endTime) + endTime.length()).trim();
                if(containesStandardChar(leftStr)) {
                    return leftStr;
                }
                if(seg.indexOf(startTime)>=0) {
                    return seg.substring(0,seg.indexOf(startTime));
                }
            }
        }
        return null;
    }

    public static boolean containesStandardChar(String... strArr) {
        for(String str : strArr) {
            if(!str.matches(".*[\u4e00-\u9fa5a-z0-9A-Z]+.*")) {
                return false;
            }
        }
        return true;
    }
}
