package program.whatever;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanxinming on 2020/9/10
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("one", "一");
        map1.put("two", "二");
        map1.put("three", "三");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("one", "yi");
        map2.put("nine", "九");
        map2.put("eight", "八");

        map1.putAll(map2);

        // 合并
//        Map<String, String> combineResultMap = new HashMap<String, String>();
//        combineResultMap.putAll(map1);
//        combineResultMap.putAll(map2);

        // 合并后打印出所有内容
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
