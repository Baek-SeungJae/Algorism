package programmers.level1;

public class Programmers_12926 {
	public static void main(String[] args) {
		String s = "a B z";
		int n = 4;
		System.out.println(solution(s, n));
	}

	public static String solution(String s, int n) {
		
		char[] chArr = s.toCharArray();
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < s.length(); i++) {
			if (chArr[i] >= 65 && chArr[i] <= 90) {
				if (((chArr[i] + n)) > 90)
					sb.append((char) ((chArr[i] + n) % 90 + 64));
				else
					sb.append((char) (chArr[i] + n));
			} else if (chArr[i] >= 97 && chArr[i] <= 122) {
				if (((chArr[i] + n)) > 122)
					sb.append((char) ((chArr[i] + n) % 122 + 96));
				else
					sb.append((char) (chArr[i] + n));
			} else if (chArr[i] ==' ') {
				sb.append(' ');
			}
		}
		
		String answer = sb.toString();
		return answer;
	}
}