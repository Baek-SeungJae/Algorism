package programmers;

public class programmers_17687 {

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		System.out.println(solution(n, t, m, p));

	}

	public static String solution(int n, int t, int m, int p) {
		/* 불필요한 계산을 하지 않기위한 반복문 횟수 지정*/
		int loop_count = t * m;
		/* 0부터 loop_count자리까지 계산할 전체 스트링빌더 */
		StringBuilder sb_all = new StringBuilder("0");
		/* 숫자 한개의 n진수 변환 스트링빌더 */
		StringBuilder sb_parts = new StringBuilder("");
		/* 0부터 시작하는 숫자 counter */
		int counter = 0;
		/* 루프는 너무 길게 끌 필요 없이 sb_all의 길이가 t*m만큼 되면 종료 */
		while (sb_all.length() <= loop_count) {
			int temp = counter;
			/* n진수 변환 로직이고 16진수까지 표현하기 위해 A~F를 스위치문으로 표현 */
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
			/* 한자리의 n진수 변환값을 sb_all에 저장하고 sb_parts는 초기화 */
			sb_all.append(sb_parts);
			sb_parts.delete(0, sb_parts.length());
			/* 카운터 증가 */
			counter++;
		}
		/* p와 m값을 이용해서 결과 완성 */
		StringBuilder sb_answer = new StringBuilder("");
		for (int i = 0; i < t; i++) {
			sb_answer.append(sb_all.charAt((p - 1) + m * i));
		}
		
		/* 결과 확인을 위한 print */
		//System.out.println(sb_all);
		//System.out.println(sb_answer);
		
		/* 정답 리턴하고 종료 */
		String answer = sb_answer.toString();
		return answer;
	}
}
