package program.learning.leetcode;

/**
 * Created by yanxinming on 2020/7/5
 */
public class Id70 {
    private static int climbStairs(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        int n2 = 1;
        int n1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = n1 + n2;
            n2 = n1;
            n1 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
