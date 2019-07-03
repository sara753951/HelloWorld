package headfirst.FilterInputStreamDecoratorTest;


import java.io.*;

/**
 * Created by yanxinming on 2019/1/20
 */
public class InputTest {

    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream( System.getProperty("user.dir") + "/src/main/java/headfirst/FilterInputStreamDecoratorTest/test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print((char)c);;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
