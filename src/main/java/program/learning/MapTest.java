package program.learning;

import java.util.*;

/**
 * Created by yanxinming on 2019/1/18
 */
public class MapTest {

    public static void main(String[] args) {
        int n=666-1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        System.out.println(n);

        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        hashMap.put(1, Arrays.asList(1));
        hashMap.put(2, Arrays.asList(2,4));
        hashMap.put(3, Arrays.asList(3,6,9));
        hashMap.compute(4, (k,v) -> {
           if (v == null) {
               return Arrays.asList(100);
           }
           v.add(100);
           return v;
        });

//        List<Integer> testList = hashMap.computeIfAbsent(4, v -> new ArrayList<>());
//        testList.add(100);

        System.out.println(hashMap);

    }
}
