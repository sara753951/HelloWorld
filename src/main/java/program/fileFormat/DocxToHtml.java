package program.fileFormat;

import javafx.stage.StageStyle;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;
import org.docx4j.Docx4J;
import org.docx4j.Docx4jProperties;
import org.docx4j.convert.out.HTMLSettings;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by yanxinming on 2018/12/3
 */
public class DocxToHtml {

//
//    public static void main(String[] args) {
//
//        String docxPath = "/Users/yanxinming/项目文件/简历解析/简历/测试数据/本地测试/docxTest/lihongmin.docx";
//        String htmlPath = "/Users/yanxinming/项目文件/简历解析/简历/测试数据/本地测试/docxTest/zhangyu.html";
//        try {
//            fun(docxPath, htmlPath);
////            docx4jTest(docxPath, htmlPath);
////            docx2Html(docxPath, htmlPath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void docx2Html(String fileName, String outPutFile) throws TransformerException, IOException, ParserConfigurationException {
//        String fileOutName = outPutFile;
//        long startTime = System.currentTimeMillis();
//        XWPFDocument document = new XWPFDocument(new FileInputStream(fileName));
//        XHTMLOptions options = XHTMLOptions.create().indent(4);
//        // 导出图片
////        File imageFolder = new File("/Users/yanxinming/项目文件/简历解析/简历/测试数据/本地测试/docxTest/images");
////        options.setExtractor(new FileImageExtractor(imageFolder));
////        // URI resolver
////        options.URIResolver(new FileURIResolver(imageFolder));
//        File outFile = new File(fileOutName);
////        outFile.getParentFile().mkdirs();
//        OutputStream out = new FileOutputStream(outFile);
//        XHTMLConverter.getInstance().convert(document, out, options);
//        System.out.println("Generate " + fileOutName + " with " + (System.currentTimeMillis() - startTime) + " ms.");
//
//    }
//
//
//    private static void fun(String docxPath, String htmlPath) throws Exception {
//        File file = new File(docxPath);
//        XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(file.getAbsolutePath()));
////        for (int i = 0; i < xdoc.getBodyElements().size();i++) {
////            xdoc.removeBodyElement(i);
////        }
//
////        XHTMLOptions options = XHTMLOptions.create().indent( 4 );
////        OutputStream out = System.out;
////        XHTMLConverter.getInstance().convert( xdoc, out, options );
//
////        for (XWPFParagraph p : xdoc.getParagraphs())//遍历段落
////        {
////            String contents = p.getParagraphText();
////            System.out.println("p:" + contents);
////            List<XWPFRun> runsLists = p.getRuns();//获取段楼中的句列表
////            for (XWPFRun run : runsLists) {
////                System.out.println("\ttext:" + run.getText(0));
////                System.out.println("\tsize:" + run.getFontSize());
////                System.out.println("\tfont:" + run.isBold());
////            }
////        }
//
////        XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
////
////
//
//        int curT = 0;
//        List<IBodyElement> iBodyElementList = xdoc.getBodyElements();
//        for (IBodyElement iBodyElement : iBodyElementList) {
//
//
//            if(iBodyElement instanceof XWPFParagraph) {
//                XWPFParagraph paragraph = (XWPFParagraph) iBodyElement;
//                String contents = paragraph.getParagraphText();
//                System.out.println("p:" + contents);
////                List<XWPFRun> runsLists = paragraph.getRuns();//获取段楼中的句列表
////                for (XWPFRun run : runsLists) {
////                    System.out.println("\ttext:" + run.getText(0));
////                    System.out.println("\tsize:" + run.getFontSize());
////                    System.out.println("\tfont:" + run.isBold());
////                }
//            } else if (iBodyElement instanceof XWPFTable) {
//
////                XWPFTable table = iBodyElement.getBody().getTableArray(curT);
////                List<XWPFTable> tables = iBodyElement.getBody().getTables();
////                table = tables.get(curT);
////                if(table != null){
////                    System.out.println(table.getText());
////                    curT++;
////                }
//
//                XWPFTable table = (XWPFTable) iBodyElement;
//                StringBuilder sb = new StringBuilder();
//                List<XWPFTableRow> rows = table.getRows();
//                for(XWPFTableRow row : rows){
//
//                    //获取行对应的单元格
//                    List<XWPFTableCell> cells = row.getTableCells();
//                    for(XWPFTableCell cell : cells){
//                        if (cell.getTables().size() > 0) {
//                            for (XWPFTable t : cell.getTables()) {
//                                sb.append(t.getText());
//                            }
//                        } else {
//                            sb.append(cell.getText());
//                        }
//
//                    }
//                    sb.append("\n");
//
//                }
//                System.out.println("table:" + sb.toString());
//
//            } else if (iBodyElement instanceof XWPFSDT) {
//                System.out.println("this is a content...");
//            } else {
//                System.out.println("this is a " + iBodyElement.getElementType());
//            }
//        }
//    }
//
//
//
//    private static void docx4jTest(String docxPath, String htmlPath) throws Exception {
//        WordprocessingMLPackage wordMLPackage = Docx4J.load(new File(docxPath));
//
//        HTMLSettings htmlSettings = Docx4J.createHTMLSettings();
//        String imageFilePath = htmlPath.substring(0, htmlPath.lastIndexOf("/") + 1) + "/images"; // 存放图片的文件夹的路径
//        htmlSettings.setImageDirPath(imageFilePath);
//        htmlSettings.setImageTargetUri("images"); // img 中 src 路径的上一级路径
//        htmlSettings.setWmlPackage(wordMLPackage);
//        String userCSS = "html, body, div, span, h1, h2, h3, h4, h5, h6, p, a, img,  ol, ul, li, table, caption, tbody, tfoot, thead, tr, th, td " +
//                "{ margin: 0; padding: 0; border: 0;}" +
//                "body {line-height: 1; padding: 30px;} ";
//        userCSS = "body {padding: 30px;}";
//        htmlSettings.setUserCSS(userCSS); // 用户自己定义的 CSS
//
//        OutputStream os = new FileOutputStream(htmlPath);
//        Docx4jProperties.setProperty("docx4j.Convert.Out.HTML.OutputMethodXML", true);
//        Docx4J.toHTML(htmlSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
//    }
}
