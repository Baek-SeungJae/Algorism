package programmers.level2;

public class programmers_60058 {
	static StringBuilder sol = new StringBuilder("");

	public static void main(String[] args) {
		String p = "(()())()";
		System.out.println(solution(p));

	}

	public static String solution(String p) {
		if (p.equals("")) {
			return "";
		}
		String answer = v(p);
		return answer;
	}

	public static String v(String p) {
		StringBuilder u = new StringBuilder("");
		int check = 0;
		int index = 0;
		/* uê°? ?˜¬ë°”ë¥¸ ë¬¸ì?—´?´ë©? trueë°˜í™˜ */
		boolean u_is_correct = true;
		while (!p.equals("")) {
			if (p.charAt(index) == '(') {
				check++;
				u.append("(");
			} else if (p.charAt(index) == ')') {
				check--;
				u.append(')');
			}
			if (check < 0) {
				u_is_correct = u_is_correct && false;
			}
			index++;

			if (check == 0) {
				if (u_is_correct) {
					return u.toString() + v(p.substring(index));
				} else {
					String empty = "(";
					empty += v(p.substring(index)) + ")";
					empty += u.substring(1, u.length() - 1).replace("(", "*").replace(")", "(").replace("*", ")");
					return empty;
				}
			}
		}
		return "";
	}
}
