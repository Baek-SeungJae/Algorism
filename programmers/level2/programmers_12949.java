package programmers.level2;

import java.util.Stack;

public class programmers_12949 {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        System.out.println(solution(arr1, arr2));

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int col = arr1.length;
        int row = arr2[0].length;
        int inner = arr2.length;
        int[][] answer = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int sum = 0;
                for (int m = 0; m < inner; m++) {
                    sum += arr1[i][m] * arr2[m][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
