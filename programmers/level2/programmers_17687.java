package programmers.level2;

public class programmers_17687 {

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		System.out.println(solution(n, t, m, p));

	}

	public static String solution(int n, int t, int m, int p) {
		/* λΆν?? κ³μ°? ?μ§? ?κΈ°μ? λ°λ³΅λ¬? ?? μ§?? */
		int loop_count = t * m;
		/* 0λΆ??° loop_count?λ¦¬κΉμ§? κ³μ°?  ? μ²? ?€?Έλ§λΉ? */
		StringBuilder sb_all = new StringBuilder("0");
		/* ?«? ?κ°μ nμ§μ λ³?? ?€?Έλ§λΉ? */
		StringBuilder sb_parts = new StringBuilder("");
		/* 0λΆ??° ???? ?«? counter */
		int counter = 0;
		/* λ£¨ν? ?λ¬? κΈΈκ² ? ?? ??΄ sb_all? κΈΈμ΄κ°? t*mλ§νΌ ?λ©? μ’λ£ */
		while (sb_all.length() <= loop_count) {
			int temp = counter;
			/* nμ§μ λ³?? λ‘μ§?΄κ³? 16μ§μκΉμ? ???κΈ? ??΄ A~Fλ₯? ?€?μΉλ¬Έ?Όλ‘? ?? */
			while (temp != 0) {
				switch (temp % n) {
				case 10:
					sb_parts.append('A');
					break;
				case 11:
					sb_parts.append('B');
					break;
				case 12:
					sb_parts.append('C');
					break;
				case 13:
					sb_parts.append('D');
					break;
				case 14:
					sb_parts.append('E');
					break;
				case 15:
					sb_parts.append('F');
					break;
				default:
					sb_parts.append(temp % n);
					break;
				}
				temp /= n;
			}
			sb_parts.reverse();
			/* ??λ¦¬μ nμ§μ λ³??κ°μ sb_all? ???₯?κ³? sb_parts? μ΄κΈ°? */
			sb_all.append(sb_parts);
			sb_parts.delete(0, sb_parts.length());
			/* μΉ΄μ΄?° μ¦κ? */
			counter++;
		}
		/* p?? mκ°μ ?΄?©?΄? κ²°κ³Ό ??± */
		StringBuilder sb_answer = new StringBuilder("");
		for (int i = 0; i < t; i++) {
			sb_answer.append(sb_all.charAt((p - 1) + m * i));
		}
		
		/* κ²°κ³Ό ??Έ? ?? print */
		//System.out.println(sb_all);
		//System.out.println(sb_answer);
		
		/* ? ?΅ λ¦¬ν΄?κ³? μ’λ£ */
		String answer = sb_answer.toString();
		return answer;
	}
}
