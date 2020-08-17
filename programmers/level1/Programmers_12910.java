package programmers.level1;

import java.util.TreeSet;

public class Programmers_12910 {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 9, 7, 10 };
		int divisor = 5;
		solution(arr, divisor);
	}

	public static int[] solution(int[] arr, int divisor) {
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				ts.add(arr[i]);
			}
		}
		int[] answer;
		if (ts.size() == 0) {
			answer = new int[] { -1 };
		} else {
			answer = new int[ts.size()];
		}
		int index = 0;
		for (int i : ts) {
			answer[index] = i;
			index++;
		}
		return answer;
	}

}
