package program.learning.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yanxinming on 2020/6/3
 */
public class Id1 {
    //ac 暴力
    private static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    //wa
    private static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!pos.containsKey(nums[i])) {
                pos.put(nums[i], i);
            }
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                result[0] = pos.get(nums[i]) < pos.get(nums[j]) ? pos.get(nums[i]) : pos.get(nums[j]);
                result[1] = pos.get(nums[i]) < pos.get(nums[j]) ? pos.get(nums[j]) : pos.get(nums[i]);
                return result;
            } else if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
        }
        return result;
    }
    //ac
    private static int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, String> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pos.containsKey(nums[i])) {
                pos.put(nums[i], pos.get(nums[i]) + "," + i);
            } else {
                pos.put(nums[i], i + "");
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (pos.containsKey(target - nums[i])) {
                String[] indexs = pos.get(target - nums[i]).split(",");
                for (int j = 0; j < indexs.length; j++) {
                    if (Integer.parseInt(indexs[j]) != i) {
                        result[0] = i;
                        result[1] = Integer.parseInt(indexs[j]);
                        return result;
                    }
                }
            }
        }
        return result;
    }
    private static int[] twoSum4(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pos.containsKey(target - nums[i])) {
                result[0] = pos.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                pos.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        int target = 6;
        System.out.println(JSONObject.toJSONString(twoSum4(nums, target)));
    }
}
