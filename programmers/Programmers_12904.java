package programmers;

public class Programmers_12904 {

	public static void main(String[] args) {
		// String s = "abacde";
		String s = "abadd";
		System.out.println(solution(s));
	}

	public static int solution(String s) {

		StringBuffer compare = new StringBuffer(s).reverse();
		int max = 0;
		StringBuffer test = new StringBuffer("");
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
		        if(max>s.length()-i) {
					break;
				}
				if (s.contains(compare.substring(i, j))) {
					test = new StringBuffer(compare.substring(i, j));
					if (compare.substring(i, j).equals(test.reverse().toString())) {
						max = Math.max(max, j - i);
					}
				} else {
					break;
				}
			}
		}
		int answer = max;
		return answer;
	}

}