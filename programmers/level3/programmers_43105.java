package programmers.level3;

public class programmers_43105 {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
		print(triangle);
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				int upLeft = 0;
				int upRight = 0;
				if (j != 0) {
					upLeft = triangle[i - 1][j - 1];
				}
				if (j != triangle[i].length - 1) {
					upRight = triangle[i - 1][j];
				}
				int largeNumber = Math.max(upRight, upLeft);
				triangle[i][j] += largeNumber;
				answer = Math.max(triangle[i][j], answer);
			}
			print(triangle);
		}
		return answer;
	}

	public static void print(int[][] triangle) {
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				System.out.print(triangle[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
