package programmers;

import java.util.LinkedList;

public class programmers_1835 {
	static int count;

	public static void main(String[] args) {
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };
		System.out.println(solution(n, data));

	}

	public static int solution(int n, String[] data) {
		String friend = "ACFJMNRT";
		count = 0;

		/* 순열만들기위한 변수선언, 순열재귀호출 */
		LinkedList<Character> perArr = new LinkedList<Character>();
		int[] perCheck = new int[8];
		permutation(n, data, friend, 8, 8, perArr, perCheck);

		/* 전역변수로 선언한 count를 출력 */
		int answer = count;
		return answer;
	}

	public static void permutation(int N, String data[], String friend, int n, int r, LinkedList<Character> perArr,
			int[] perCheck) {
		/* 순열중 원소 한개가 완성되었을 때 */
		if (perArr.size() == r) {
			StringBuffer sb = new StringBuffer("");
			for (Character i : perArr) {
				sb.append(i);
			}
			/* string에 완성된 순열이 저장됨 */
			String string = sb.toString();
			/* 조건검사를 위한 check배열과 check배열을 종합하는 result */
			boolean[] check = new boolean[N];
			boolean result = true;
			/* 문제에서 주어진 n회 순회하며 조건체크 문자열의 위치가 고정되어 있으므로 charAt으로 검사함 불필요한 루프순회를 줄이는 break, and연산이므로 한개만 false여도 false이다. */
			for (int i = 0; i < N; i++) {
				int c = Math.abs(string.indexOf(String.valueOf(data[i].charAt(0)))
						- string.indexOf(String.valueOf(data[i].charAt(2)))) - 1;
				if (data[i].charAt(3) == '=') {
					if (c == Integer.parseInt(String.valueOf(data[i].charAt(4)))) {
						check[i] = true;
					} else {
						break;
					}
				} else if (data[i].charAt(3) == '<') {
					if (c < Integer.parseInt(String.valueOf(data[i].charAt(4)))) {
						check[i] = true;
					} else {
						break;
					}
				} else if (data[i].charAt(3) == '>') {
					if (c > Integer.parseInt(String.valueOf(data[i].charAt(4)))) {
						check[i] = true;
					} else {
						break;
					}
				}
			}
			/* check의 결과를 result에 종합, check.length는 N과 같다. */
			for (int j = 0; j < check.length; j++) {
				result = result && check[j];
			}
			if (result) {
				count++;
			}
			return;
		}
		
		/* 순열을 구하기 위한 재귀함수 */
		for (int i = 0; i < n; i++) {
			if (perCheck[i] == 0) {
				perArr.add(friend.charAt(i));
				perCheck[i] = 1;
				permutation(N, data, friend, n, r, perArr, perCheck);
				perCheck[i] = 0;
				perArr.removeLast();
			}
		}

	}
}
