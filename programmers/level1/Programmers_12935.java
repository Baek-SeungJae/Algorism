package programmers.level1;

public class Programmers_12935 {
	public static void main(String[] args) {
		int[] arr = new int[] { 10 };
		System.out.println(solution(arr));
	}

	public static int[] solution(int[] arr) {
		int[] answer;
		int min = Integer.MAX_VALUE;
		int indexofmin = 0;

		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
				indexofmin = i;
			}
		}

		if (arr.length != 1) {
			answer = new int[arr.length - 1];
			int index = 0;
			for (int i = 0; i < arr.length; i++) {
				if (indexofmin == i) {
					continue;
				}
				answer[index] = arr[i];
				index++;
			}
		} else {
			answer = new int[] { -1 };
		}

		return answer;
	}
}