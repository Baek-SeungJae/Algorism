package daily;

/*
정수 배열과 정수 k가 주어지면 모든 원소를 k칸씩 앞으로 옮기시오.
Given an array and an integer K, shift all elements in the array K times.
input: [1, 2, 3, 4, 5], k = 2
output: [3, 4, 5, 1, 2]
input: [0, 1, 2, 3, 4], k = 1
output: [1, 2, 3, 4, 0]
시간복잡도와 공간복잡도를 최대한 최적화 하시오.
 */

public class O20200405 {
	public static void main(String[] args) {
		int[] input = new int[] { 0, 1, 2, 3, 4 };
		int key = 1;

		int[] result = solution(input, key);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);

	}

	public static int[] solution(int[] input, int key) {
		int[] result = new int[input.length];
		for(int i=0; i<result.length; i++) {
			if(key+i>=result.length) {
				key = key - result.length;
			}
			result[i] = input[key+i];
		}
		return result;
	}
}