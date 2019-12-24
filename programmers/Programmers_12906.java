package programmers;

import java.util.Stack;

public class Programmers_12906 {

	public static void main(String[] args) {
		int arr[] = new int[] { 4, 4, 4, 3, 3 };
		solution(arr);
	}

	public static int[] solution(int[] arr) {
		
		Stack<Integer> st = new Stack<>();
		st.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (st.peek() != arr[i]) {
				st.add(arr[i]);
			}
		}
		System.out.println(st);
		int[] answer = new int[st.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = st.get(i);
		}
		return answer;
	}

}
