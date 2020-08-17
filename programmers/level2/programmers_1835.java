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

		/* ?ˆœ?—´ë§Œë“¤ê¸°ìœ„?•œ ë³??ˆ˜?„ ?–¸, ?ˆœ?—´?¬ê·??˜¸ì¶? */
		LinkedList<Character> perArr = new LinkedList<Character>();
		int[] perCheck = new int[8];
		permutation(n, data, friend, 8, 8, perArr, perCheck);

		/* ? „?—­ë³??ˆ˜ë¡? ?„ ?–¸?•œ countë¥? ì¶œë ¥ */
		int answer = count;
		return answer;
	}

	public static void permutation(int N, String data[], String friend, int n, int r, LinkedList<Character> perArr,
			int[] perCheck) {
		/* ?ˆœ?—´ì¤? ?›?†Œ ?•œê°œê? ?™„?„±?˜?—ˆ?„ ?•Œ */
		if (perArr.size() == r) {
			StringBuffer sb = new StringBuffer("");
			for (Character i : perArr) {
				sb.append(i);
			}
			/* string?— ?™„?„±?œ ?ˆœ?—´?´ ???¥?¨ */
			String string = sb.toString();
			/* ì¡°ê±´ê²??‚¬ë¥? ?œ„?•œ checkë°°ì—´ê³? checkë°°ì—´?„ ì¢…í•©?•˜?Š” result */
			boolean[] check = new boolean[N];
			boolean result = true;
			/* ë¬¸ì œ?—?„œ ì£¼ì–´ì§? n?šŒ ?ˆœ?šŒ?•˜ë©? ì¡°ê±´ì²´í¬ ë¬¸ì?—´?˜ ?œ„ì¹˜ê? ê³ ì •?˜?–´ ?ˆ?œ¼ë¯?ë¡? charAt?œ¼ë¡? ê²??‚¬?•¨ ë¶ˆí•„?š”?•œ ë£¨í”„?ˆœ?šŒë¥? ì¤„ì´?Š” break, and?—°?‚°?´ë¯?ë¡? ?•œê°œë§Œ false?—¬?„ false?´?‹¤. */
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
			/* check?˜ ê²°ê³¼ë¥? result?— ì¢…í•©, check.length?Š” Nê³? ê°™ë‹¤. */
			for (int j = 0; j < check.length; j++) {
				result = result && check[j];
			}
			if (result) {
				count++;
			}
			return;
		}
		
		/* ?ˆœ?—´?„ êµ¬í•˜ê¸? ?œ„?•œ ?¬ê·??•¨?ˆ˜ */
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
