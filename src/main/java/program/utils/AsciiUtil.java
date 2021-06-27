package program.utils;

import cn.hutool.core.date.DateUtil;
import org.apache.commons.codec.binary.StringUtils;

import java.io.IOException;

/**
 * Created by yanxinming on 2018/12/6
 */
public class AsciiUtil {



    public static char ascii2Char(int ASCII) {
        return (char) ASCII;
    }

    public static int char2ASCII(char c) {
        return (int) c;
    }

    public static String ascii2String(int[] ASCIIs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ASCIIs.length; i++) {
            sb.append((char) ascii2Char(ASCIIs[i]));
        }
        return sb.toString();
    }

    public static String ascii2String(String ASCIIs) {
        String[] ASCIIss = ASCIIs.split(",");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ASCIIss.length; i++) {
            sb.append((char) ascii2Char(Integer.parseInt(ASCIIss[i])));
        }
        return sb.toString();
    }

    public static int[] string2ASCII(String s) {// 字符串转换为ASCII码
        if (s == null || "".equals(s)) {
            return null;
        }

        char[] chars = s.toCharArray();
        int[] asciiArray = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            asciiArray[i] = char2ASCII(chars[i]);
        }
        return asciiArray;
    }

    public static String getIntArrayString(int[] intArray) {
        return getIntArrayString(intArray, ",");
    }

    public static String getIntArrayString(int[] intArray, String delimiter) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i]).append(delimiter);
        }
        return sb.toString();
    }

    public static String getASCII(int begin, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = begin; i < end; i++) {
            sb.append(i).append(":").append((char) i).append("/t");
            // sb.append((char) i).append("/t");
            if (i % 10 == 0) {
                sb.append("/n");
            }
        }
        return sb.toString();
    }

    public static String getCHASCII(int begin, int end) {
        return getASCII(19968, 40869);
    }

    public static void showASCII(int begin, int end) {
        for (int i = begin; i < end; i++) {
            // System.out.print(i + ":" + (char) i + "/t");
            System.out.print((char) i + "/t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void showCHASCII() {
        showASCII(19968, 40869);
    }

    public static void showIntArray(int[] intArray) {
        showIntArray(intArray, ",");
    }

    public static void showIntArray(int[] intArray, String delimiter) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + delimiter);
        }
    }

//    public static void createFile(String filePathAndName, String fileContent)
//            throws IOException {
//
//        String filePath = filePathAndName;
//        filePath = filePath.toString();
//        File myFilePath = new File(filePath);
//        if (!myFilePath.exists()) {
//            myFilePath.createNewFile();
//        }
//        FileWriter resultFile = new FileWriter(myFilePath);
//        PrintWriter myFile = new PrintWriter(resultFile);
//        String strContent = fileContent;
//        myFile.println(strContent);
//        myFile.close();
//        resultFile.close();
//    }

    public static void main(String[] args) throws IOException {

        if (DateUtil.parse("2020-08-04 22:10:00").before(DateUtil.parse("2020-08-04"))) {
            System.out.println("1false");
        }
        if (DateUtil.parse("2020-08-04 22:10:00").after(DateUtil.parse("2020-08-05"))) {
            System.out.println("2false");
        }
//        String s = "北京城市学院";
//        showIntArray(string2ASCII(s), " ");
//        System.out.println();
//        int[] asciiArray = {21271,20140,22478,24066,23398,38498};
//        System.out.println(ascii2String(asciiArray));

//        createFile("c://console_ch.txt", getCHASCII(0, 50000));
    }


}
