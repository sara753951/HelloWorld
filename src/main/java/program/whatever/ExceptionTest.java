package program.whatever;

import java.util.Date;

/**
 * Created by yanxinming on 2020/3/17
 */
public class ExceptionTest {

    public static void main(String[] args) {

        System.out.println(new Date());

        int x = 1;
        try {

            if (x < 10) {
                return;
            } else {
                System.out.println("ok");
            }

        } catch (Exception e) {
            System.out.println("catch..");
        } finally {
            System.out.println("finally..");
        }
        System.out.println("end");
    }
}
