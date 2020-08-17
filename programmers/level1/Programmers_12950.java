package programmers.level1;

public class Programmers_12950 {
	public static void main(String[] args) {
		int[][] arr1 = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] arr2 = new int[][] { { 1, 2 }, { 3, 4 } };

		solution(arr1, arr2);

	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {

		int rowsize = arr1[0].length;
		int colsize = arr1.length;
		int[][] answer = new int[colsize][rowsize];
		for (int i = 0; i < colsize; i++) {
			for (int j = 0; j < rowsize; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}

		return answer;
	}
}