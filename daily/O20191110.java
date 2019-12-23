package daily;
/*
�ȳ��ϼ���, �������α׷��� �̹��� �����Դϴ�.

�Ǻ���ġ �迭�� 0�� 1�� �����ϸ�, ���� �Ǻ���ġ ���� �ٷ� ���� �� �Ǻ���ġ ���� ���� �ȴ�. ���� N�� �־�����, N���� ���� ��� ¦�� �Ǻ���ġ ���� ���� ���Ͽ���.

Fibonacci sequence starts with 0 and 1 where each fibonacci number is a sum of two previous fibonacci numbers. Given an integer N, find the sum of all even fibonacci numbers.

����)
Input: N = 12
Output: 10 // 0, 1, 2, 3, 5, 8 �� ¦���� 2 + 8 = 10.
*/

public class O20191110 {
	public static void main(String[] args) {
		int input = 12; // ���ǻ� �Է����� ���� �ʾ���
		int sum = 0;
		int a = 1;
		int b = 2;
		int temp;
		while (b < input) {
			if (b % 2 == 0)
				sum += b;
			temp = a;
			a = b;
			b = temp + b;
		}
		System.out.println(sum);
	}
}
