package program.learning.leetcode;

/**
 * Created by yanxinming on 2019/7/4
 */
public class Id11 {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,3,5,4,8,3,7};
        System.out.println(maxArea2(height));
        int[] h2 = new int[]{2,3,4,5,18,17,6};
        System.out.println(maxArea2(h2));
    }

    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int[] dp = new int[height.length];
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                dp[j] = Math.max(Math.max(dp[j - 1],dp[j]), (j - i) * Math.min(height[i], height[j]));
            }
        }

        return dp[height.length - 1];
    }

    public static int maxArea2(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, height[i] * (j - i));
                i++;
            } else {
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
        }

        return max;
    }
}
