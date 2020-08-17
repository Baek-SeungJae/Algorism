package programmers.level1;

public class Programmers_12912 {
	public static void main(String[] args) {
		int a = 3;
		int b = 3;
		solution(a, b);

	}

	public static long solution(int a, int b) {
		long answer = 0;
		
		int s;
		int e;
		if (a >= b) {
			s = b;
			e = a;
		} else {
			s = a;
			e = b;
		}
		for(int i = s; i<=e; i++) {
			answer += i;
		}
		System.out.println(answer);
		return answer;
	}
}