package programmers.level2;

public class programmers_62048 {

	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		System.out.println(solution(w, h));

	}

	public static long solution(int w, int h) {
		long answer = 0;
		double slope = (double) h / w;
		for (int i = 0; i < h; i++) {
			answer += ((int) (i / slope));
		}
		answer *= 2;
		return answer;
	}
}
