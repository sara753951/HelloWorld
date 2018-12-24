package fileFormat;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.File;
import java.io.IOException;

/**
 * Created by yanxinming on 2018/10/30
 */
public class PrintTextLocations extends PDFTextStripper {

    public PrintTextLocations() throws IOException {
        super.setSortByPosition(true);
    }
    /**
     * @param text The text to be processed
     */
    @Override /* this is questionable, not sure if needed... */
    protected void processTextPosition(TextPosition text) {
        System.out.println(
                "\nfspt=" + text.getFontSizeInPt() +"\tWidth=" + text.getWidth() + "\tHeight" + text.getHeight() +
                        "\nx=" + text.getX() + "\ty=" + text.getY() +
                        "\nfont="+ text.getFont()+
                        "\n" + text.getUnicode());
//        if (text.getUnicode().equals("教")) {
//            System.out.println(text);
//        }
    }

    public static void main(String[] args) throws Exception {

        PDDocument document = null;

        File input = new File("/Users/yanxinming/项目文件/简历解析/简历/本地测试/巴晓夏简历.pdf");
        document = PDDocument.load(input);
        System.out.println(document.getDocumentCatalog().getPages().getCount());

        PrintTextLocations printer = new PrintTextLocations();
        printer.getText(document);

    }


}
