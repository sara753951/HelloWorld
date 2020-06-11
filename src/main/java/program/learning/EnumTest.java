package program.learning;

import cn.hutool.core.util.EnumUtil;
import org.apache.commons.lang3.EnumUtils;

import java.util.Map;

/**
 * Created by yanxinming on 2018/12/10
 */
public class EnumTest {

    public enum testType{
        Test1,Test2
    }

    public static void main(String[] args) {
//        if ("Test1".equals(testType.Test1.toString())) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }


        String str = "冰洗";
        SecondDeptEnum s = SecondDeptEnum.valueOf("AC");
        Map<String, Object> enumMap = EnumUtil.getNameFieldMap(SecondDeptEnum.class, "secondDept");
        System.out.println(enumMap.values().contains(str));
    }
}
