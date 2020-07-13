package program.learning.leetcode;

public class Id338 {

    private static int[] countBits(int num) {
        int[] res = new int[num + 1];
        if (num >= 0) {
            res[0] = 0;
        }
        if (num > 0) {
            res[1] = 1;
        }
        for (int i = 2; i <= num; i++) {
            res[i] = res[i / 2] + (i % 2);
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5;
        int[] array = countBits(num);
        for (int i = 0; i <= num; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
