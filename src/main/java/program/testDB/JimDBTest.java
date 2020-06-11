package program.testDB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yanxinming on 2019/4/16
 */
public class JimDBTest {

    public static void main(String[] args) {

        Set<String> testSet = new HashSet<>();
        testSet.add("1");
        testSet.add("2");
        System.out.println(testSet.toArray());

        List<String> testList = new ArrayList<>();
        testList.add("a");
        testList.add("b");
        System.out.println(testList.toArray());


    }
}
