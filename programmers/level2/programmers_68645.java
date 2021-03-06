package programmers.level2;

public class programmers_68645 {

	public static int LENGTH;

	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));

	}

	public static int[] solution(int n) {
		// 0 -> 내려감, 1-> 오른쪽, 2-> 올라감
		int directionFlag = 0;

		// 위치가 움직일 방향, direction에 의해 결정됨 [direction][i], [direction][j]
		int[][] directionMove = {{1, 0}, {0, 1}, {-1, -1}};

		// 삼각배열 생성
		int[][] triArray = new int[n][];
		for (int i = 0; i < n; i++) {
			triArray[i] = new int[i + 1];
		}

		int value = 1; // 초기값

		// n이 가질 수 있는 최대길이, 가우스법칙 응용
		LENGTH = (1 + n) * n / 2;

		// 현재 위치
		int currentI = 0;
		int currentJ = 0;

		// 삼각형안에 포함된 길이만큼 움직인다.
		while (value <= LENGTH) {
			triArray[currentI][currentJ] = value;
			value++;

			int nextI = currentI + directionMove[directionFlag][0];
			int nextJ = currentJ + directionMove[directionFlag][1];
			if (!isIncludedArrayBounds(n, nextI, nextJ, currentI, triArray)
					|| isVisited(nextI, nextJ, triArray)) {
				directionFlag++;
				directionFlag = directionFlag % 3;
				nextI = currentI + directionMove[directionFlag][0];
				nextJ = currentJ + directionMove[directionFlag][1];
			}

			currentI = nextI;
			currentJ = nextJ;
			print(triArray);
		}

		return answer(triArray);
	}

	public static void print(int[][] triArray) {
		for (int i = 0; i < triArray.length; i++) {
			for (int j = 0; j < triArray[i].length; j++) {
				System.out.print(triArray[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean isIncludedArrayBounds(int n, int nextI, int nextJ, int currentI, int[][] triArray) {
		return (nextI < n && nextI >= 0 && nextJ < triArray[currentI].length && nextJ >= 0);
	}

	public static boolean isVisited(int nextI, int nextJ, int[][] triArray) {
		return triArray[nextI][nextJ] != 0;
	}

	public static int[] answer(int[][] triArray) {
		int[] answer = new int[LENGTH];
		int index = 0;
		for (int i = 0; i < triArray.length; i++) {
			for (int j = 0; j < triArray[i].length; j++) {
				answer[index] = triArray[i][j];
				index++;
			}
		}
		return answer;
	}
}
