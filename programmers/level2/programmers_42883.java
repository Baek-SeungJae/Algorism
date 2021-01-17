package programmers.level2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class programmers_42883 {

	public static void main(String[] args) {
		String number1 = "1924";
		int k1 = 2;
		String number2 = "1231234";
		int k2 = 3;
		String number3 = "4177252841";
		int k3 = 4;

		System.out.println(solution(number1, k1));
		System.out.println(solution(number2, k2));
		System.out.println(solution(number3, k3));
	}

	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder(number);
		int startIndex = 0;
		for(int i=0; i<k; i++){
			boolean isDelete = false;
			for(int j=startIndex; j< sb.length()-1; j++){
				if(sb.charAt(j) < sb.charAt(j+1)){
					sb.deleteCharAt(j);
					isDelete = true;
					startIndex = Math.max(0,j-1);
					break;
				}
			}
			if(!isDelete){
				sb.deleteCharAt(sb.length()-1);
				startIndex = Math.max(0,sb.length() -2);
			}
		}
		String answer = sb.toString();
		return answer;
	}
}
