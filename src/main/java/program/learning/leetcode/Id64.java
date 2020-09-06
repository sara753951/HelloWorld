package program.learning.leetcode;

public class Id64 {

    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m < 1) {
            return 0;
        }
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0;j < n; j++) {
                if (0 == i && 0 == j) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                int up = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
                int left = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},
                {1,5,1},
                {4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
