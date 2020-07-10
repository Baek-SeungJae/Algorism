package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_42585 {

	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}

	public static int solution(String arrangement) {
		arrangement = arrangement.replace("()", ".");
		int stack = 0;
		int answer = 0;
		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '.') {
				answer += stack;
			} else if (arrangement.charAt(i) == '(') {
				stack += 1;
			} else {
				stack -= 1;
				answer += 1;
			}
		}
		System.out.println(answer);

		return answer;
	}

}
