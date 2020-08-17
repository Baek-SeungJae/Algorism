package programmers.level2;

public class programmers_12980 {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));

	}

	public static int solution(int n) {
		int ans = 0;
		/* n?„ ?´ì§„ìˆ˜?˜•?ƒœë¡? ë°”ê¿”?„œ Stringë³??ˆ˜ str?— ???¥ */
		String str = dec2bin(n);
		
		/* str?—?„œ 1?˜ ê°œìˆ˜ë¥? ì¹´ìš´?Š¸ */
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				ans++;
			}
		}
		return ans;
	}

	public static String dec2bin(int a) {

		StringBuffer sb = new StringBuffer("");

		while (true) {

			if (a % 2 == 1) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			if ((a == 0 || a == 1))
				break;
			a = a / 2;
		}
		sb.reverse();
		return sb.toString();
	}
}
