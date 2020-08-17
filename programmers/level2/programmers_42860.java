package programmers.level2;

import java.util.Deque;
import java.util.LinkedList;

public class programmers_42860 {

	public static void main(String[] args) {
		String name = "AABAAAAAAABBB";
		solution(name);
		/*
		String[] names = { "CANAAAAANAN", "AAAAACANAAAAANANAAAAAA", "JAN", "JEROEN", "BBAAAAA", "JJAJAAAAAAAAAJ",
				"AJAJAA", "BBABA", "BBBAAB", "BBAABAA", "BBAABBB", "BBAABAAAA", "BBAABAAAAB", "ABAAAAAAABA", "AAB",
				"AABAAAAAAABBB", "ZZZ", "BBBBAAAAAB", "BBBBAAAABA", "ABABAAAAAAABA", "BBBBBBBABB" };

		int[] answers = { 48, 56, 23, 56, 3, 41, 21, 6, 8, 7, 10, 7, 10, 6, 2, 11, 5, 10, 12, 10, 18 };

		for (int i = 0; i < names.length; i++) {
			int ret = solution(names[i]); // ?—¬ê¸°ëŠ” ê°ì ì½”ë“œ?— ë§ê²Œ ?ˆ˜? •?•˜ë©? ?©?‹ˆ?‹¤.
			if (ret != answers[i]) {
				System.out.println("names[i]: " + names[i]);
				System.out.println("answers[i]: " + answers[i]);
				System.out.println("ret: " + ret + "\n");
			}
		}
		*/
	}

	public static int solution(String name) {
		/* ?—°?‚°?„ ?œ„?•œ intë³??ˆ˜ ?„ ?–¸ ë°? ì´ˆê¸°?™”, alphabet?? ?•Œ?ŒŒë²³ë??™˜?šŸ?ˆ˜ cursor?Š” ?´?™?šŸ?ˆ˜ not_A?Š” Aê°? ?•„?‹Œê°??ˆ˜ */
		int alphabet = 0;
		int cursor = name.length();
		int not_A = 1;

		/* ?•Œ?ŒŒë²³ë??™˜?šŸ?ˆ˜ë¥? êµ¬í•˜ê³?, Aê°? ?•„?‹Œ ê°??ˆ˜ë¥? êµ¬í•¨ */
		for (int i = 0; i < name.length(); i++) {
			/* ë©”ì†Œ?“œ?™”?•´?„œ ê°??…?„± ?–¥?ƒ */
			alphabet += change_A(name, i);
			if (name.charAt(i) != 'A') {
				not_A++;
			}
		}
		
		/* ì»¤ì„œ?´?™?šŸ?ˆ˜ë¥? êµ¬í•˜?Š” ë©”ì†Œ?“œ*/
		cursor = cursor_move(name, not_A);
		
		int answer = alphabet + cursor;
		return answer;
	}

	/* Aë¥? ë§Œë“¤ê¸? ?œ„?•œ ?šŸ?ˆ˜ */
	public static int change_A(String name, int index) {
		int counter = (int) 'A' - name.charAt(index);
		StringBuilder sb = new StringBuilder(name);
		sb.replace(index, index + 1, "A");
		name = sb.toString();
		if (counter + 26 > 13) {
			return Math.abs(counter);
		} else {
			return counter + 26;
		}
	}
	
	/* ì»¤ì„œ ?´?™ ?šŸ?ˆ˜ */
	public static int cursor_move(String name, int not_A) {
		int cursor = name.length();
		/* ?—°?‚°?¸?˜ë¥? ?œ„?•´ name?˜ 0ë²ˆì¸?±?Š¤ë¥? ?…? ¥?œ¼ë¡? ì£¼ì–´ì§? ?ˆ˜ ?—†?Š” zë¡? ë³??™˜ */
		name = '*' + name.substring(1);
		/* q1 ê°??¥ ì§§ì? ê¸¸ì´ë¥? êµ¬í•˜?Š” deque, q2?Š” ?—°?‚° ?›„ q1?„ ë³µì›?•˜ê¸? ?œ„?•œ deque, q3?? ? ‘?‘,? ‘ë¯¸ê¸¸?´ë¥? ë°˜í™˜?•˜ê¸? ?œ„?•œ deque-z?‘ ?—°ê²? */
		Deque<Character> q1 = new LinkedList<Character>();
		Deque<Character> q2 = new LinkedList<Character>();
		Deque<Character> q3 = new LinkedList<Character>();
		
		/* deque ì´ˆê¸°?™” */
		for (int i = 0; i < name.length(); i++) {
			q1.addLast(name.charAt(i));
			q2.addLast(name.charAt(i));
		}
		
		System.out.println("ì´ˆê¸°?ƒ?ƒœ");
		System.out.println(q1);
		System.out.println();
		
		/* ì»¤ì„œ?´?™?šŸ?ˆ˜ë¥? ê³„ì‚° */
		for (int i = 0; i < not_A; i++) {
			/* q1?—?„œ ìµœì¢Œì¸? Aë¥? ? œê±°í•˜ë©´ì„œ q2?— ì¶”ê? */
			while (q1.peekFirst() == 'A') {
				q2.removeFirst();
				q2.addLast(q1.removeFirst());
			}
			/* q1?—?„œ ìµœìš°ì¸? Aë¥? ? œê±? */
			while (q1.peekLast() == 'A') {
				q1.removeLast();
			}
			/* ?´ ?ƒ?ƒœë¡? q3?— q1?„ ë³µì‚¬?•˜ê³?, ? ‘?‘, ? ‘ë¯? ê¸¸ì´ë¥? êµ¬í•¨ */
			q3.addAll(q1);
			int prefix = -1;
			/* ?•?„œ ?´?š©?•˜ê¸°ë¡œ ?•œ 'z'ë¥? ?´?š©?•´?„œ ? ‘?‘ ? ‘ë¯¸ê¸¸?´ë¥? êµ¬í•¨ */
			while (q3.removeFirst() != '*') {
				prefix++;
			}
			
			int suffix = q3.size() - 1;
			/* ê³„ì‚°?•œ ê°’ê³¼ ìµœì†Ÿê°’ì„ ë¹„êµ?•´?„œ ìµœì†Ÿê°? ???¥ */
			cursor = Math.min(cursor, q1.size() + Math.min(prefix, suffix));
			
			/* ?—°?‚°?´ ì¢…ë£Œ?œ deque ? •ë¦? */
			q2.addLast(q1.removeFirst());
			q2.removeFirst();
			q1.clear();
			q3.clear();
			q1.addAll(q2);

		}
		return cursor;
	}
}
