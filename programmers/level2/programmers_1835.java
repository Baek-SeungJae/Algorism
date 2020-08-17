package programmers.level2;

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

		/* ?��?��만들기위?�� �??��?��?��, ?��?��?���??���? */
		LinkedList<Character> perArr = new LinkedList<Character>();
		int[] perCheck = new int[8];
		permutation(n, data, friend, 8, 8, perArr, perCheck);

		/* ?��?���??���? ?��?��?�� count�? 출력 */
		int answer = count;
		return answer;
	}

	public static void permutation(int N, String data[], String friend, int n, int r, LinkedList<Character> perArr,
			int[] perCheck) {
		/* ?��?���? ?��?�� ?��개�? ?��?��?��?��?�� ?�� */
		if (perArr.size() == r) {
			StringBuffer sb = new StringBuffer("");
			for (Character i : perArr) {
				sb.append(i);
			}
			/* string?�� ?��?��?�� ?��?��?�� ???��?�� */
			String string = sb.toString();
			/* 조건�??���? ?��?�� check배열�? check배열?�� 종합?��?�� result */
			boolean[] check = new boolean[N];
			boolean result = true;
			/* 문제?��?�� 주어�? n?�� ?��?��?���? 조건체크 문자?��?�� ?��치�? 고정?��?�� ?��?���?�? charAt?���? �??��?�� 불필?��?�� 루프?��?���? 줄이?�� break, and?��?��?���?�? ?��개만 false?��?�� false?��?��. */
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
			/* check?�� 결과�? result?�� 종합, check.length?�� N�? 같다. */
			for (int j = 0; j < check.length; j++) {
				result = result && check[j];
			}
			if (result) {
				count++;
			}
			return;
		}
		
		/* ?��?��?�� 구하�? ?��?�� ?���??��?�� */
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
