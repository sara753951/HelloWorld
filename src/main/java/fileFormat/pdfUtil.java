package fileFormat;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxinming on 2018/10/30
 */
public class pdfUtil extends PDFTextStripper {

    static List<Float> list_postion = new ArrayList<Float>();
    static List<String> list_text = new ArrayList<String>();


    public pdfUtil() throws IOException {
        super.setSortByPosition(true);
    }

    public static void main(String[] args) throws Exception {

//        PDDocument document = null;
//        try {
//            File input = new File("/Users/yanxinming/项目文件/简历解析/简历/19日测试简历/自有简历PDF 10/李明宇简历2018年07月（对象存储）.pdf");
//            document = PDDocument.load(input);
//            if (document.isEncrypted()) {
//                document.decrypt("");
//            }
//            pdfUtil printer = new pdfUtil();
//            List allPages = document.getDocumentCatalog().getAllPages();
//            for (int i = 0; i < allPages.size(); i++) {
//                PDPage page = (PDPage) allPages.get(i);
//                System.out.println("Processing page: " + i);
//                PDStream contents = page.getContents();
//                if (contents != null) {
//                    printer.processStream(page, page.findResources(), page.getContents().getStream());
//                }
//            }
//        } finally {
//            if (document != null) {
//                document.close();
//            }
//        }
//
//        System.out.println("list_text："+list_text.size());
//        for(int i = 0;i < list_text.size();i++){
//            System.out.println(list_text.get(i) );
//        }

    }

    /**
     * @param text The text to be processed
     */
    @Override /* this is questionable, not sure if needed... */
    protected void processTextPosition(TextPosition text) {

//        list_text.add("String[" + text.getXDirAdj() + ","
//                + text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale="
//                + text.getXScale()+ " yscale="
//                + text.getYScale() + " height=" + text.getHeightDir() + " space="
//                + text.getWidthOfSpace() + " width="
//                + text.getWidthDirAdj() + " x="
//                + text.getX() + " y="
//                + text.getY() +  "]" + text.getCharacter());

//        System.out.println("String[" + text.getXDirAdj() + ","
//                + text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale="
//                + text.getXScale()+ " yscale="
//                + text.getYScale() + " height=" + text.getHeightDir() + " space="
//                + text.getWidthOfSpace() + " width="
//                + text.getWidthDirAdj() + " x="
//                + text.getX() + " y="
//                + text.getY() + " y1="
//                + text.getTextPos().getYPosition() + " x1="
//                + text.getTextPos().getXPosition() + " x1="
//                + text.getTextPos().getXScale() + " x1="
//                + text.getTextPos().getYScale() + " font：" + text.getFont().getBaseFont()+ "]" + text.getCharacter());
    }



}
