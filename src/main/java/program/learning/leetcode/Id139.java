package program.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Id139 {

    //递归
    private static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() <= 1) {
            return wordDict.contains(s);
        }
        if (wordDict.contains(s)) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (wordBreak(s.substring(0, i), wordDict) && wordBreak(s.substring(i, s.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }

    //dp 记录中间过程
    private static boolean wordBreak2(String s, List<String> wordDict) {
        if (s.length() <= 1) {
            return wordDict.contains(s);
        }
        if (wordDict.contains(s)) {
            return true;
        }
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            if (dp[i] && wordDict.contains(s.substring(i, s.length()))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
//        String s = "catsandog";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("cat");

        System.out.println(wordBreak2(s, wordDict));
    }
}
