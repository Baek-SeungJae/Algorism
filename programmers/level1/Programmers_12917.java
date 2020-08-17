package programmers.level1;

import java.util.Arrays;

public class Programmers_12917 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		solution(s);

	}

	public static String solution(String s) {
		char[] chararr = s.toCharArray();
		Arrays.sort(chararr);
		StringBuffer sb = new StringBuffer("");
		sb.append(chararr);
		String answer = sb.reverse().toString();
		return answer;
	}
}