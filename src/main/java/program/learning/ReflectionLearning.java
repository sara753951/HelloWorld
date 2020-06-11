package program.learning;

import java.lang.reflect.Method;

/**
 * Created by yanxinming on 2018/11/15
 */
public class ReflectionLearning {

    public static void main(String[] args) throws Exception{
        String className = "program.UnicodeCheck";
        String methodName = "test";


        Class classTest = Class.forName(className);
        Object object = classTest.newInstance();
        Method method = object.getClass().getDeclaredMethod(methodName, String.class);
        String result = (String) method.invoke(object);
        System.out.println(result);


    }
}
