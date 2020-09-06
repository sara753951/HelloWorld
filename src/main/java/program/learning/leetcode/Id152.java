package program.learning.leetcode;

/**
 * Created by yanxinming on 2020/7/9
 */
public class Id152 {

    private static int maxProduct(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int preMax = nums[0];
        int preMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMaxTemp = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            preMin = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i]));
            preMax = preMaxTemp;
            max = Math.max(max, preMax);

        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,-1,4};
        System.out.println(maxProduct(nums));
    }
}
