package program.learning.leetcode;

import java.util.Arrays;

/**
 * Created by yanxinming on 2020/7/19
 */
public class Id494 {

    private static int findTargetSumWays(int[] nums, int S) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length < 2) {
            if (nums[0] == S || nums[0] == -S) {
                return 1;
            }
            return 0;
        }
        return findTargetSumWays(Arrays.copyOfRange(nums, 0, nums.length - 1), S + nums[nums.length - 1])
                + findTargetSumWays(Arrays.copyOfRange(nums, 0, nums.length - 1), S - nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1};
        int s = 1;
        System.out.println(findTargetSumWays(nums, s));
    }
}
