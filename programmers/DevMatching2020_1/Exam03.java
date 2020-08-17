package programmers.DevMatching2020_1;

import java.util.ArrayList;

public class Exam03 {

	public static void main(String[] args) {
		int[] numbers = new int[] { 3, 7, 2, 8, 6, 4, 5, 1 };
		int K = 3;
		System.out.println(solution(numbers, K));
	}

	public static int solution(int[] input, int K) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int k = 0;
		int numbers[] = input.clone();
		int count = 0;
		for (int i = k; i < numbers.length - 1; i++) {
			if (Math.abs(numbers[i] - numbers[i + 1]) > K) {
				int max = 0;
				int mj = 0;
				for (int j = i + 1; j < numbers.length - 1; j++) {
					if (Math.abs(numbers[i] - numbers[j]) <= K) {
						if (Math.abs(numbers[i] - numbers[j]) >= max) {
							max = Math.abs(numbers[i] - numbers[j]);
							mj = j;
						}
					}
					if (j == numbers.length - 2) {
						swap(numbers, i + 1, mj);
						count++;
						i = k+1;
						break;
					}
				}
			}
			if(count>20) {
				count=-1;
				break;
			}
		}
		list.add(count);
		k = 1;
		numbers = input.clone();
		count = 0;
		for (int i = k; i < numbers.length - 1; i++) {
			if (Math.abs(numbers[i] - numbers[i + 1]) > K) {
				int max = 0;
				int mj = 0;
				for (int j = i + 1; j < numbers.length - 1; j++) {
					if (Math.abs(numbers[i] - numbers[j]) <= K) {
						if (Math.abs(numbers[i] - numbers[j]) >= max) {
							max = Math.abs(numbers[i] - numbers[j]);
							mj = j;
						}
					}
					if (j == numbers.length - 2) {
						swap(numbers, i + 1, mj);
						count++;
						i = k+1;
						break;
					}
				}
			}
			if(count>20) {
				count=-1;
				break;
			}
		}
		list.add(count);
		if(list.get(1)==0) {
			list.remove(1);
		}
		list.sort(null);
		int answer = (list.get(0));
		return answer;
	}

	public static void swap(int[] numbers, int first, int second) {
		int temp = numbers[first];
		numbers[first] = numbers[second];
		numbers[second] = temp;
	}
}
