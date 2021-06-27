package program.learning.leetcode;

/**
 * Created by yanxinming on 2020/7/5
 */
public class Id121 {
    private static int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int min = 0;
        int[] results = new int[prices.length];
        results[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            results[i] = Math.min(results[i - 1], prices[i]);
            if (prices[i] - results[i] > min) {
                min = prices[i] - results[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7,7,6,4,3,1};
        System.out.println(maxProfit(array));
    }
}
