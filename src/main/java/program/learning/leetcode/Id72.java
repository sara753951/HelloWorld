package program.learning.leetcode;

/**
 * Created by yanxinming on 2020/7/12
 */
public class Id72 {

    private static int minDistance(String word1, String word2) {
        if (word2.length() < 1) {
            return word1.length();
        }
        if (word1.length() < 1) {
            return word2.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) +  1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        long t1 = System.currentTimeMillis();
        String str1 = "你好，欢迎来到小米之家欢迎来到小米之家欢迎来到小米之家";
        String str2 = "你好，欢迎来到小米之家欢迎来到小米之家欢迎来到小米之家,hh";
        System.out.println(minDistance(str1, str2));
        System.out.println(System.currentTimeMillis() - t1);
    }
}
