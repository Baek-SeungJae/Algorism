package daily;
//2차 정수 배열(2D int array)가 주어지면, 소용돌이 모양으로 원소들을 프린트하시오. 예제를 보시오.
/*
    예제)
   input:
   [[1, 2, 3],
   [8, 9, 4],
   [7, 6, 5]]
   Output:
   1, 2, 3, 4, 5, 6, 7, 8, 9
 */
public class O20200308 {
	static int count = 0;

	public static void main(String[] args) {
      int[][] input = { { 1, 2, 3, 4}, { 12, 13, 14, 5}, { 11, 16, 15, 6 }, {10,9,8,7} };
      int rowsize = input[0].length;
      int colsize = input.length;
      int row = 0;
      int col = 0;
      int inputsize = rowsize*colsize;
      int check = 0;
      while (true) {
         if(check==inputsize)
            break;
         for (int j = row; j < rowsize; j++) {
            System.out.print(input[col][j] + " ");
            check++;
         }
         if(check==inputsize)
            break;
         col = col + 1;
         for (int i = col; i < colsize; i++) {
            System.out.print(input[i][rowsize - 1] + " ");
            check++;
         }
         if(check==inputsize)
            break;
         rowsize = rowsize - 1;
         for (int i = rowsize - 1; i >= row; i--) {
            System.out.print(input[colsize - 1][i] + " ");
            check++;
         }
         if(check==inputsize)
            break;
         colsize = colsize - 1;
         for (int j = colsize - 1; j >= col; j--) {
            System.out.print(input[j][row] + " ");
            check++;
         }
         row = row + 1;
      }

   }
}