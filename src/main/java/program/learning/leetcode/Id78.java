package program.learning.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxinming on 2020/7/25
 */
public class Id78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int len = results.size();
            for (int j = 0; j < len; j++) {
                List list = new ArrayList<>(results.get(j));
                list.add(nums[i]);
                results.add(list);
            }
        }
        return results;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(JSON.toJSONString(subsets(nums)));
    }
}
