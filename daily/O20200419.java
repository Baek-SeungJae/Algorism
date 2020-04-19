package daily;

/*
정렬된 정수 배열이 있습니다. 이 배열의 모든 원소들을 오른쪽으로 랜덤하게 Z번 이동하였습니다.
예를 들면 [1, 2, 3, 4, 5] -> [3, 4, 5, 1, 2].
이런 배열과 정수 K 가 주어지면, 배열안에 K가 존재하는지 찾으시오.
존재한다면 배열의 인덱스, 존재하지 않다면 -1 을 리턴하시오.
시간복잡도 제한 O(log N).
input: [3, 4, 5, 1, 2], 4
output: 1
input: [2, 4, 5, 1], 3
output: -1
input: [4, 6, 7, 8, 1, 2, 3], 5
output: -1
 */

public class O20200419 {
	public static void main(String[] args) {
		int[] input = new int[] { 3, 4, 5, 1, 2 };
		int key = 1;

		System.out.println(solution(input, key));

	}

	public static int solution(int[] input, int key) {

		int first = 0, last = input.length - 1;
		int result = -1;
		while (first < last) {
			int mid = (first + last) / 2;
			if (input[mid] > input[first])
				first = mid;
			else
				last = mid;
		}
		int diff = input.length - 1 - last;
		first = 0;
		last = input.length - 1;
		while (first <= last) {
			int mid = (first + last) / 2;
			int tmp = mid;
			if (mid >= diff)
				tmp -= diff;
			else
				tmp = input.length - (diff - mid);
			if (input[tmp] > key)
				last = mid - 1;
			else if (input[tmp] < key)
				first = mid + 1;
			else {
				result = tmp;
				break;
			}
		}

		return result;
	}
}