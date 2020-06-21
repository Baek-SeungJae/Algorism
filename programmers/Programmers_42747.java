package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_42747 {
	public static void main(String[] args) {
		int[] answer = new int[] { 0, 1, 3, 5, 5, 5, 5, 5, 5, 6 };
		System.out.println(solution(answer));

	}

	public static int solution(int[] citations) {
		
		Integer[] temp = new Integer[citations.length];
		for (int i = 0; i < citations.length; i++) {
			temp[i] = citations[i];
		}
		Arrays.sort(temp,Comparator.reverseOrder());
		int answer = 0;
		for (int i = 0; i < temp.length; i++) {
			if (i+1 <= temp[i]) {
				answer++;
			}
		}
		return answer;
	}
}