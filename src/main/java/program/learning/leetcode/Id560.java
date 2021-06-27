package program.learning.leetcode;

import java.util.HashMap;

/**
 * Created by yanxinming on 2020/6/7
 */
public class Id560 {

    //ac 暴力
    private static int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            sum = 0;
            while (j < nums.length) {
                sum += nums[j++];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    //
    private static int subarraySum2(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                result++;
            }
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,1,2,1};
        int k = 3;
        System.out.println(subarraySum2(array, k));
//        int[] array = new int[]{1,-1,3,-3};
//        int k = 0;
//        System.out.println(subarraySum2(array,k));
    }
}
