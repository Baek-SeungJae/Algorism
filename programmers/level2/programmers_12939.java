package programmers.level2;

public class programmers_12939 {

	public static void main(String[] args) {
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}

	public static String solution(String str) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		String[] integer = str.split(" ");
		for (int i = 0; i < integer.length; i++) {
			int temp = Integer.parseInt(integer[i]);
			max = Math.max(max, temp);
			min = Math.min(min, temp);
		}
		String answer = min + " " + max;
		return answer;
	}
}
