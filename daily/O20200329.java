package daily;

/*
정렬(sort)된 정수 배열과 정수 n이 주어지면, 배열안에 n이 있는지 체크하시오. 시간복잡도를 최대한 최적화하시오.
Given a sorted integer array and an integer N, check if N exists in the array.
예제)
Input: [1, 2, 3, 7, 10], 7
Output: true
Input: [-5, -3, 0, 1], 0
Output: true
Input: [1, 4, 5, 6, 8, 9], 10
Output: false
 */

public class O20200329 {
	public static void main(String[] args) {
		int[] input = new int[] {1, 4, 5, 6, 8, 9};
		int find = 9;

		System.out.println(solution(input, find));

	}

	public static boolean solution(int[] input, int find) {
		
		int first = 0;
		int last = input.length-1;
		int index = (last + first)/2;
		while(true) {
			if(input[index]>find) {
				last = index-1;
				if(index==((last + first)/2))
					return false;
				index = (last + first)/2;
			} else if(input[index]<find) {
				first = index+1;
				if(index==((last + first)/2))
					return false;
				index = (last + first)/2;
			} else if(input[index]==find) {
				return true;
			}
		}
	}
}