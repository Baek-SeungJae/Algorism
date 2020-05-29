package programmers.DevMatching2020_2;

import java.util.ArrayList;
import java.util.TreeSet;

public class e2 {
	public static void main(String[] args) {
		long p = 100;
		System.out.println(solution(p));
	}

	public static long solution(long n) {

		String dec2bin = dec2bin(n);
		long answer = 0;
		for (int i = 0; i < dec2bin.length(); i++) {
			if (Integer.parseInt(dec2bin.charAt(i) + "") == 1) {
				answer += (long) Math.pow(3, i);
			}
		}
		return answer;
	}

	public static String dec2bin(long a) {

		StringBuffer sb = new StringBuffer("");

		while (true) {

			if (a % 2 == 1) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			if ((a == 0 || a == 1))
				break;
			a = a / 2;
		}
		return sb.toString();
	}
}
