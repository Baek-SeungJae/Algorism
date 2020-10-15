package daily;

/*
 정수 배열(int array)이 주어지면 두번째로 큰 값을 프린트하시오.
Given an integer array, find the second largest element.

예제)
Input: [10, 5, 4, 3, -1]
Output: 5
Input: [3, 3, 3]
Output: Does not exist.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class O20191222 {

	public static void main(String[] args) {
		int[] input = { 3, 3, 3 };
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < input.length; i++) {
			set.add(input[i]);
		}
		ArrayList<Integer> arr = new ArrayList<Integer>(set);
		arr.sort(Collections.reverseOrder());

		if (arr.size() >= 2)
			System.out.println(arr.get(1));
		else
			System.out.println("Does not exits.");
	}
}
