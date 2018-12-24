package utils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by yanxinming on 2018/11/7
 */
public class fileUtil {

    public static String readerByLine(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> contents = new ArrayList<String>();
        File file = new File(path);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static ArrayList<String> readLines(File file, String encoding) {
        ArrayList<String> contents = new ArrayList<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                contents.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static void getWholeHtmlText (String txtFilePath, String encoding) {
        StringBuffer sb = new StringBuffer();
        try{

            File file = new File(txtFilePath);
            String tmpLineVal;
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
            BufferedReader bufread = new BufferedReader(read);

            while((tmpLineVal = bufread.readLine())!=null)
            {

                System.out.print(tmpLineVal);
            }
            System.out.println();
            bufread.close();
            read.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static String getWholeHtmlText2 (File file, String encoding) {
        StringBuffer sb = new StringBuffer();
        try{
            String tmpLineVal;
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
            BufferedReader bufread = new BufferedReader(read);

            while((tmpLineVal = bufread.readLine())!=null)
            {
                sb.append(tmpLineVal);
            }
            System.out.println();
            bufread.close();
            read.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        readerByLine("/Users/yanxinming/项目文件/简历解析/简历/测试数据/本地测试/mhtTest/linmei.doc");
        getWholeHtmlText("/Users/yanxinming/项目文件/简历解析/简历/UT/回归181119/mengyueyun.docx","utf-8");
//        getWholeHtmlText("/Users/yanxinming/项目文件/简历解析/简历/03第三轮自测2/03第三轮自测2/猎聘-18份，18-0/马妍-加盟经理-猎聘网简历.doc","utf-8");



//        String content = readerByLine("/Users/yanxinming/项目文件/简历解析/简历/03第三轮自测2/03第三轮自测2/猎聘-18份，18-0/songhanyan.doc");
//        System.out.println(content);
    }
}
