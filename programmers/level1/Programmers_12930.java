package programmers.level1;

public class Programmers_12930 {
	public static void main(String[] args) {
		String s = "try  hello world";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		char[] charArr = s.toCharArray();
		int evenodd = 0;
		for (int i = 0; i < charArr.length; i++) {
			if (evenodd % 2 == 0) {
				charArr[i] = Character.toUpperCase(charArr[i]);
			} else {
				charArr[i] = Character.toLowerCase(charArr[i]);
			}
			evenodd++;
			if (charArr[i] == ' ') {
				evenodd = 0;
			}
		}
		String answer = new String(charArr);
		return answer;
	}
}