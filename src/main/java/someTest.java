/**
 * Created by yanxinming on 2018/9/11
 */
public class someTest {

    public static void main(String[] args) {

        String string = "qaz";
        StringBuilder sb = new StringBuilder(string);
        doSomeTh(sb);
        string = sb.toString();
        System.out.println(string);

        System.out.println(getTimeLineLeftStr("###2016 年 -‐ 至今        深圳奥思数据科技有限公司               CTO ###2017 年 -‐ 至今      西安交通大学研究生院       外聘专家 ","2016 年","今"));



        String s1 = "R32冷媒：R32冷媒为全新冷媒，其主要特点为能有效提高产品的能源效率及制冷制热量指标，同时不会对地球造成任何污染的冷媒，目前日本大部份空调已采用R32冷媒~";
        String s2 = "R32冷媒：R32冷媒为全新冷媒，其主要特点为能有效提高产品的能源效率及制冷制热量指标";

//        s1 = "abcd";
//        s2 = "abcd";

        System.out.println(new someTest().similar(s1, s2));


        String s = "hello my world life";
        s = s.replaceAll("[^\\S]","");
        System.out.println(s);


        String str = " 请问下 现在 下单购买    大概什么时候负责安装？";
        str = str.replaceAll("\\p{P}","").trim();
        str = str.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5\\s]+","").trim();
        System.out.println(str);
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
