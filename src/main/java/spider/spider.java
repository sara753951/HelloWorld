package spider;

import org.apache.xmlbeans.impl.regex.Match;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.fileUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanxinming on 2019/1/3
 */
public class spider {

    private static String outputPath = "/Users/yanxinming/Downloads/position_51.txt";
    private static HashSet<String> positionSet = new HashSet<>();
    private static Pattern pattern = Pattern.compile("(^|[^\u4e00-\u9fa5a-z])([\u4e00-\u9fa5a-z]+)($|[^\u4e00-\u9fa5a-z])");

//    static String baseUrl = "https://search.51job.com/list/010000%252C020000%252C030200%252C040000,000000,0000,00,9,99,%2520,2,%d.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";

    public static void main(String[] args) {

//        String u = fun();
//        String html = getHtml(u);

//        extractPositionFrom51job();

        extractPositionFromLagou();

        try {
            OutputStream outputStream = fileUtil.openFiletoWrite(outputPath);
            positionSet.forEach(position -> {
                try {
                    fileUtil.writeStringToFile(outputStream, position + "\n", "utf-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void extractPositionFromLagou() {
        for (int i = 5400000; i <= 5479537 ; i++) {
            String lagouUrl = "https://www.lagou.com/jobs/" + i + ".html";
            getPositionFromLagou(lagouUrl);
        }
        System.out.println();

    }

    private static void getPositionFromLagou(String lagouUrl) {
        String htmlText = getHtml(lagouUrl);
        Document doc = Jsoup.parse(htmlText);
        Elements aElements = doc.select("a");
        aElements.forEach(aElement -> {
            if (aElement.attr("class").equals("position_link")) {
                String position = aElement.select("h3").get(0).text();
                positionSet.add(position);
            }
        });
    }

    private static void extractPositionFrom51job() {
        for (int i = 1; i <= 2000 ; i++) {
            if (i % 20 == 0) {
                System.out.println();
                System.out.print(i);
            }
            String url = "https://search.51job.com/list/010000%252C020000%252C030200%252C040000,000000,0000,00,9,99,%2B,2," + i + ".html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=01&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=22&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
            getPositionFrom51job(url);
        }

    }

    private static void getPositionFrom51job(String url) {


        String htmlText = getHtml(url);
        Document doc = Jsoup.parse(htmlText);
        Elements divElements = doc.select("div");
        Elements positionDivElements = new Elements();
        divElements.forEach(divElement -> {
            if (divElement.attr("class").equals("dw_table")) {
                positionDivElements.add(divElement);
            }
        });

        Elements positionTitleDivElements = positionDivElements.get(0).children();
        positionTitleDivElements.forEach(positionTitleDivElement -> {
            if (positionTitleDivElement.is("div") && positionTitleDivElement.attr("class").equals("el")) {
                String position = positionTitleDivElement.select("p").get(0).text();

//                position = position.replaceAll("[（）\\(\\)]", "");
//                Matcher matcher = pattern.matcher(position);
//                if (matcher.find()) {
//                    position = matcher.group(2);
//                }
                positionSet.add(position);

            }
        });
    }

    private static String getHtml(String urlStr) {

        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection URLconnection = url.openConnection();
            URLconnection = reload(URLconnection);
            HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
//            Thread.sleep(1000);
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.err.print(".");
                InputStream in = httpConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, "UTF-8");
                BufferedReader bufr = new BufferedReader(isr);
                String str;
                while ((str = bufr.readLine()) != null) {
                    sb.append(str);
                }
                bufr.close();
            } else {
                System.err.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    private static URLConnection reload(URLConnection uc) throws Exception {
        HttpURLConnection huc = (HttpURLConnection) uc;

        if (huc.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP
                || huc.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM)// 302, 301  
            return reload(new URL(huc.getHeaderField("location")).openConnection());

        return uc;

    }

    private static String fun() {
        String url = "https://www.lagou.com/jobs/5479537.html";
        System.out.println("访问地址:" + url);
        URL serverUrl = null;
        try {
            serverUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) serverUrl
                    .openConnection();
            conn.setRequestMethod("GET");
            // 必须设置false，否则会自动redirect到Location的地址
            conn.setInstanceFollowRedirects(false);

            conn.addRequestProperty("Accept-Charset", "UTF-8;");
            conn.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
            conn.addRequestProperty("Referer", "http://zuidaima.com/");
            conn.connect();
            String location = conn.getHeaderField("Location");

            serverUrl = new URL(location);
            conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");

            conn.addRequestProperty("Accept-Charset", "UTF-8;");
            conn.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
            conn.addRequestProperty("Referer", "http://zuidaima.com/");
            conn.connect();
            System.out.println("跳转地址:" + location);
            return location;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
