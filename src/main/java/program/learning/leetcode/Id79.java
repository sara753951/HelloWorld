package program.learning.leetcode;

/**
 * Created by yanxinming on 2020/7/26
 */
public class Id79 {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m < 1) {
            return false;
        }
        int n = board[0].length;
        if (n < 1) {
            return false;
        }
        int[][] path =  new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existPath(board, word, path, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existPath(char[][] board, String word, int[][] path, int i, int j, int index) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || index >= word.length() || path[i][j] == 1) {
            return false;
        }
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] == word.charAt(index)) {
            path[i][j] = 1;
            if (existPath(board, word, path, i - 1, j, index + 1)
                    || existPath(board, word, path, i, j + 1, index + 1)
                    || existPath(board, word, path, i + 1, j, index + 1)
                    || existPath(board, word, path, i, j - 1, index + 1)) {
                return true;
            }
        }
        path[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCB";
        System.out.println(exist(board, word));
    }
}
