package program.learning.leetcode;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by yanxinming on 2020/6/5
 */
public class Id136 {
    //ac
    private static int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,3,4};
        System.out.println(JSONObject.toJSONString(singleNumber(nums)));
    }
}
