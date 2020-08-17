package programmers.level1;

public class Programmers_12922 {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}

	public static String solution(int n) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				sb.append("?ˆ˜");
			} else {
				sb.append("ë°?");
			}
		}
		String answer = sb.toString();
		return answer;
	}
}