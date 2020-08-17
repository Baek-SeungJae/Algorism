package programmers.DevMatching2020_1;

public class Exam01 {

	public static void main(String[] args) {
		String p = "82195";
		String s = "64723";
		System.out.println(solution(p, s));
	}

	public static int solution(String p, String s) {
		int count = 0;
		for (int i = 0; i < p.length(); i++) {
			int num1 = Integer.parseInt(p.charAt(i) + "");
			int num2 = Integer.parseInt(s.charAt(i) + "");
			int temp = num1 - num2;
			temp = Math.abs(temp);
			if (temp >= 5) {
				temp = 10 - temp;
			}
			count += temp;
		}
		int answer = count;
		return answer;
	}
}
