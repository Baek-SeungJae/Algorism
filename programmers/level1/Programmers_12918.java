package programmers.level1;

public class Programmers_12918 {
	public static void main(String[] args) {
		String s = "++23";
		solution(s);

	}

	public static boolean solution(String s) {
		boolean size = true;
		boolean numberFormat = true;
		if (s.length() == 4 || s.length() == 6) {
			size = true;
		} else {
			size = false;
		}

		try {
			Long.parseLong(s);
		} catch (NumberFormatException e) {
			numberFormat = false;
		}
		if (s.charAt(0) == '-' || s.charAt(0) == '+') {
			numberFormat = false;
		}

		boolean answer = size && numberFormat;
		System.out.println(answer);
		return answer;
	}
}