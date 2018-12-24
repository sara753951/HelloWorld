package fileFormat;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.PrintWriter;

/**
 * Created by yanxinming on 2018/11/12
 */
public class itextPdfAnalyzer {

    public static void main(String[] args) {

        String contents = readPdf("/Users/yanxinming/项目文件/简历解析/简历/03第三轮自测2/03第三轮自测2/boss-8份，5-3/hanxiansheng.pdf");
        System.out.println(contents);
    }

    public static String readPdf( String fileName){
        String pageContent = "";
        try {
            PdfReader reader = new PdfReader(fileName);
            int pageNum = reader.getNumberOfPages();
            for(int i=1;i<=pageNum;i++){
                pageContent += PdfTextExtractor.getTextFromPage(reader, i);//读取第i页的文档内容
            }
//            writer.write(pageContent);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
//            writer.close();
        }
        return pageContent;
    }

}
