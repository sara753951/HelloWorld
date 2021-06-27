package program.learning.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Created by yanxinming on 2020/6/10
 */
public class Id15 {
    //ac 转化成two sum
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) {
            return results;
        }

        Arrays.sort(nums);
        HashMap<Integer, List<List<Integer>>> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > 0) {
                 break;
            }
            List<List<Integer>> twoSumList = twoSum2(Arrays.copyOfRange(nums, i + 1, nums.length), 0 - nums[i]);
            if (twoSumList.size() > 0) {
                resultMap.put(nums[i], twoSumList);
            }
        }
        Iterator it = resultMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            for (List<Integer> list : (List<List<Integer>>)entry.getValue()) {
                list.add((Integer) entry.getKey());
                results.add(list);
            }
        }

        return results;
    }

    private static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.add(target - nums[i]);
                results.add(result);
            }
            set.add(nums[i]);
        }

        return results;
    }
    private static List<List<Integer>> twoSum2(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();

        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            if (nums[i] + nums[j] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.add(target - nums[i]);
                results.add(result);
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return results;
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) {
            return results;
        }

        Arrays.sort(nums);
        HashMap<Integer, List<List<Integer>>> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            List<List<Integer>> twoSumList = twoSum2(Arrays.copyOfRange(nums, i + 1, nums.length), 0 - nums[i]);
            if (twoSumList.size() > 0) {
                resultMap.put(nums[i], twoSumList);
            }
        }
        Iterator it = resultMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            for (List<Integer> list : (List<List<Integer>>)entry.getValue()) {
                list.add((Integer) entry.getKey());
                results.add(list);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,1,-1};
        System.out.println(JSONObject.toJSONString(threeSum(nums)));

    }
}
