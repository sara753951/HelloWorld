package fileFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.fileUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by yanxinming on 2018/11/9
 */
public class htmlUtil {

    public static void main(String[] args){


        File htmlFile = new File("/Users/yanxinming/项目文件/简历解析/简历/03第三轮自测2/03第三轮自测2/智联-17份，17-0/zhangyanfei.doc");

        String htmlText = fileUtil.getWholeHtmlText2(htmlFile, "utf-8");
        //            Document doc = Jsoup.parse(htmlFile, "utf-8", " http://example.com");
        Document doc = Jsoup.parse(htmlText);

        Elements elements = doc.select("div").get(0).children();
        for (Element element : elements) {
            if(element.is("table")) {
                Elements rows = element.select("tr");
                for (Element row : rows) {
                    System.out.println("tr:\t" + row.text());
                }
            } else if (element.is("p")) {
//                System.out.println("p:\t");
                System.out.println("p:\t" + element.text());
            } else {
                System.out.print("other:\t");
                System.out.println(element.text());
            }
        }


    }
}
