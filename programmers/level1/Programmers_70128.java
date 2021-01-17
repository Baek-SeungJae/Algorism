package programmers.level1;

public class Programmers_70128 {
	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4 };
		int[] b1 = { -3, -1, 0, 2 };
		System.out.println(solution(a1, b1));

		int[] a2 = { -1, 0, 1 };
		int[] b2 = { 1, 0, -1 };

		System.out.println(solution(a2, b2));
	}

	public static int solution(int[] a, int[] b) {

		int answer = 0;
		for (int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
		return answer;
	}
}