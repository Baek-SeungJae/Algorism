package programmers.level1;

public class Programmers_12919 {
	public static void main(String[] args) {
		int n = 1000000;
		solution(n);

	}

	public static int solution(int n) {
		int answer = 0;

		boolean[] isprime = new boolean[n + 1];
		isprime[1] = true;

		for (int i = 2; i * i <= n; i++) {
			for (int j = i * 2; j <= n; j += i) {
				isprime[j] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!isprime[i])
				answer++;
		}
		System.out.println(answer);
		return answer;
	}
}