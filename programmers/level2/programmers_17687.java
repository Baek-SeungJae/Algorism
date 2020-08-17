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
		/* 불필?��?�� 계산?�� ?���? ?��기위?�� 반복�? ?��?�� �??��*/
		int loop_count = t * m;
		/* 0�??�� loop_count?��리까�? 계산?�� ?���? ?��?��링빌?�� */
		StringBuilder sb_all = new StringBuilder("0");
		/* ?��?�� ?��개의 n진수 �??�� ?��?��링빌?�� */
		StringBuilder sb_parts = new StringBuilder("");
		/* 0�??�� ?��?��?��?�� ?��?�� counter */
		int counter = 0;
		/* 루프?�� ?���? 길게 ?�� ?��?�� ?��?�� sb_all?�� 길이�? t*m만큼 ?���? 종료 */
		while (sb_all.length() <= loop_count) {
			int temp = counter;
			/* n진수 �??�� 로직?���? 16진수까�? ?��?��?���? ?��?�� A~F�? ?��?��치문?���? ?��?�� */
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
			/* ?��?��리의 n진수 �??��값을 sb_all?�� ???��?���? sb_parts?�� 초기?�� */
			sb_all.append(sb_parts);
			sb_parts.delete(0, sb_parts.length());
			/* 카운?�� 증�? */
			counter++;
		}
		/* p?? m값을 ?��?��?��?�� 결과 ?��?�� */
		StringBuilder sb_answer = new StringBuilder("");
		for (int i = 0; i < t; i++) {
			sb_answer.append(sb_all.charAt((p - 1) + m * i));
		}
		
		/* 결과 ?��?��?�� ?��?�� print */
		//System.out.println(sb_all);
		//System.out.println(sb_answer);
		
		/* ?��?�� 리턴?���? 종료 */
		String answer = sb_answer.toString();
		return answer;
	}
}
