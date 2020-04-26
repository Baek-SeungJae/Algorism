package daily;

/*
정수 배열이 주어지면 , 배열 안의 모든 정수의 최대 공약수(GCD)를 구하시오.
시간 복잡도 제한 O(n)
Given an integer array, find the greatest common denominator of all elements.
input: [3, 2, 1]
output: 1
input: [2, 4, 6, 8]
output: 2
 */

public class O20200426 {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 8 };
		
		System.out.println(solution(arr));
	}
	

	// Function to find gcd of array of
	// numbers
	public static int solution(int arr[]) {
		int n = arr.length;
		int result = arr[0];
		for (int i = 1; i < n; i++) {
			result = gcd(arr[i], result);

			if (result == 1) {
				return 1;
			}
		}

		return result;
	}
	
	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
	
}