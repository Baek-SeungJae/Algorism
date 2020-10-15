package daily;

/*
정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 모든 0을 배열 오른쪽 끝으로 옮기시오. 단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.
Given an integer array, move all the 0s to the right of the array without changing the order of non-zero elements.

예제)
Input: [0, 5, 0, 3, -1]
Output: [5, 3, -1, 0, 0]
Input: [3, 0, 3]
Output: [3, 3, 0]*/
import java.util.ArrayList;

public class O20191229 {

	public static void main(String[] args) {
		int[] input = { 3, 0, 3 };
		int inputsizefirst = input.length;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			arr.add(input[i]);
		}
		while ((arr.indexOf(0)) >= 0) {
			arr.remove(arr.indexOf(0));
		}
		int inputsizelast = arr.size();

		for (int i = 0; i < inputsizefirst - inputsizelast; i++)
			arr.add(0);

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
