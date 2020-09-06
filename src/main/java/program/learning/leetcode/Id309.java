package program.learning.leetcode;

/**
 * Created by yanxinming on 2020/7/11
 */
public class Id309 {

    private static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int preFreeze = 0;
        int preNotFreeze = 0;
        int preHold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int tempPreHold = preHold;
            preHold = Math.max(preHold, preNotFreeze - prices[i]);
            preNotFreeze = Math.max(preFreeze, preNotFreeze);
            preFreeze = tempPreHold + prices[i];
        }

        return Math.max(preFreeze, preNotFreeze);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
