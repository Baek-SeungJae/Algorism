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
		/* ë¶ˆí•„?š”?•œ ê³„ì‚°?„ ?•˜ì§? ?•Šê¸°ìœ„?•œ ë°˜ë³µë¬? ?šŸ?ˆ˜ ì§?? •*/
		int loop_count = t * m;
		/* 0ë¶??„° loop_count?ë¦¬ê¹Œì§? ê³„ì‚°?•  ? „ì²? ?Š¤?Š¸ë§ë¹Œ?” */
		StringBuilder sb_all = new StringBuilder("0");
		/* ?ˆ«? ?•œê°œì˜ nì§„ìˆ˜ ë³??™˜ ?Š¤?Š¸ë§ë¹Œ?” */
		StringBuilder sb_parts = new StringBuilder("");
		/* 0ë¶??„° ?‹œ?‘?•˜?Š” ?ˆ«? counter */
		int counter = 0;
		/* ë£¨í”„?Š” ?„ˆë¬? ê¸¸ê²Œ ?Œ ?•„?š” ?—†?´ sb_all?˜ ê¸¸ì´ê°? t*më§Œí¼ ?˜ë©? ì¢…ë£Œ */
		while (sb_all.length() <= loop_count) {
			int temp = counter;
			/* nì§„ìˆ˜ ë³??™˜ ë¡œì§?´ê³? 16ì§„ìˆ˜ê¹Œì? ?‘œ?˜„?•˜ê¸? ?œ„?•´ A~Fë¥? ?Š¤?œ„ì¹˜ë¬¸?œ¼ë¡? ?‘œ?˜„ */
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
			/* ?•œ?ë¦¬ì˜ nì§„ìˆ˜ ë³??™˜ê°’ì„ sb_all?— ???¥?•˜ê³? sb_parts?Š” ì´ˆê¸°?™” */
			sb_all.append(sb_parts);
			sb_parts.delete(0, sb_parts.length());
			/* ì¹´ìš´?„° ì¦ê? */
			counter++;
		}
		/* p?? mê°’ì„ ?´?š©?•´?„œ ê²°ê³¼ ?™„?„± */
		StringBuilder sb_answer = new StringBuilder("");
		for (int i = 0; i < t; i++) {
			sb_answer.append(sb_all.charAt((p - 1) + m * i));
		}
		
		/* ê²°ê³¼ ?™•?¸?„ ?œ„?•œ print */
		//System.out.println(sb_all);
		//System.out.println(sb_answer);
		
		/* ? •?‹µ ë¦¬í„´?•˜ê³? ì¢…ë£Œ */
		String answer = sb_answer.toString();
		return answer;
	}
}
