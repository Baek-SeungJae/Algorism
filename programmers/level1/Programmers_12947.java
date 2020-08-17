package programmers.level1;

import java.util.Arrays;

public class Programmers_12947 {
	public static void main(String[] args) {
		long n = 118372;
		System.out.println(solution(n));
	}

	public static long solution(long n) {
		char[] charArr = (n+"").toCharArray();
		Arrays.sort(charArr);
		StringBuffer sb = new StringBuffer();
		sb.append(charArr);
		sb.reverse();
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}