package cmb.Coding;

import java.util.Arrays;

public class Test06 {
    public static void main(String[] args) {
        int rows = 3, cols = 4;
        char[] matrix = "abcesfcsadee".toCharArray();
        // 标记matrix中哪些块被访问过
        int[] flag = new int[matrix.length];
        char[] charFromStr = "bcced".toCharArray();
        boolean hasPath = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                hasPath = solution(matrix, flag, charFromStr, rows, cols, i, j, 0);
            }
        }
        if (hasPath) {
            System.out.println("has path");
        } else {
            System.out.println("has no path");
        }
    }

    // 访问到i行j列，str[]的第k个字符
    public static boolean solution(char[] matrix, int[] flag, char[] str, int row, int col, int i, int j, int k) {
        int index = i * col + j;
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[index] != str[k] || flag[index] == 1) {
            return false;
        }
        flag[index] = 1;
        // 匹配完成
        if (k == str.length - 1) {
            System.out.println("true");
            return true;
        }
        if (solution(matrix, flag, str, row, col, i - 1, j, k + 1) ||
                solution(matrix, flag, str, row, col, i + 1, j, k + 1) ||
                solution(matrix, flag, str, row, col, i, j - 1, k + 1) ||
                solution(matrix, flag, str, row, col, i, j + 1, k + 1)) {
            return true;
        }
        // 清零，回溯
        flag[index] = 0;
        return false;
    }
}
