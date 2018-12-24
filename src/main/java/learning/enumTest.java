package learning;

/**
 * Created by yanxinming on 2018/12/10
 */
public class enumTest {

    public enum testType{
        Test1,Test2
    }

    public static void main(String[] args) {
        if ("Test1".equals(testType.Test1.toString())) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
