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

		/* ??΄λ§λ€κΈ°μ? λ³??? ?Έ, ??΄?¬κ·??ΈμΆ? */
		LinkedList<Character> perArr = new LinkedList<Character>();
		int[] perCheck = new int[8];
		permutation(n, data, friend, 8, 8, perArr, perCheck);

		/* ? ?­λ³??λ‘? ? ?Έ? countλ₯? μΆλ ₯ */
		int answer = count;
		return answer;
	}

	public static void permutation(int N, String data[], String friend, int n, int r, LinkedList<Character> perArr,
			int[] perCheck) {
		/* ??΄μ€? ?? ?κ°κ? ??±??? ? */
		if (perArr.size() == r) {
			StringBuffer sb = new StringBuffer("");
			for (Character i : perArr) {
				sb.append(i);
			}
			/* string? ??±? ??΄?΄ ???₯?¨ */
			String string = sb.toString();
			/* μ‘°κ±΄κ²??¬λ₯? ?? checkλ°°μ΄κ³? checkλ°°μ΄? μ’ν©?? result */
			boolean[] check = new boolean[N];
			boolean result = true;
			/* λ¬Έμ ?? μ£Όμ΄μ§? n? ???λ©? μ‘°κ±΄μ²΄ν¬ λ¬Έμ?΄? ?μΉκ? κ³ μ ??΄ ??Όλ―?λ‘? charAt?Όλ‘? κ²??¬?¨ λΆν?? λ£¨ν??λ₯? μ€μ΄? break, and?°?°?΄λ―?λ‘? ?κ°λ§ false?¬? false?΄?€. */
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
			/* check? κ²°κ³Όλ₯? result? μ’ν©, check.length? Nκ³? κ°λ€. */
			for (int j = 0; j < check.length; j++) {
				result = result && check[j];
			}
			if (result) {
				count++;
			}
			return;
		}
		
		/* ??΄? κ΅¬νκΈ? ?? ?¬κ·??¨? */
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
