package program.learning.leetcode;

public class Id96 {
    private static int numTrees(int n) {
        if (1 == n || 0 == n) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        return sum;
    }
    private static int numTrees2(int n) {
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (1 == i || 0 == i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees2(5));
    }
}