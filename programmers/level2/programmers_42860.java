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
			int ret = solution(names[i]); // ?��기는 각자 코드?�� 맞게 ?��?��?���? ?��?��?��.
			if (ret != answers[i]) {
				System.out.println("names[i]: " + names[i]);
				System.out.println("answers[i]: " + answers[i]);
				System.out.println("ret: " + ret + "\n");
			}
		}
		*/
	}

	public static int solution(String name) {
		/* ?��?��?�� ?��?�� int�??�� ?��?�� �? 초기?��, alphabet?? ?��?��벳�??��?��?�� cursor?�� ?��?��?��?�� not_A?�� A�? ?��?���??�� */
		int alphabet = 0;
		int cursor = name.length();
		int not_A = 1;

		/* ?��?��벳�??��?��?���? 구하�?, A�? ?��?�� �??���? 구함 */
		for (int i = 0; i < name.length(); i++) {
			/* 메소?��?��?��?�� �??��?�� ?��?�� */
			alphabet += change_A(name, i);
			if (name.charAt(i) != 'A') {
				not_A++;
			}
		}
		
		/* 커서?��?��?��?���? 구하?�� 메소?��*/
		cursor = cursor_move(name, not_A);
		
		int answer = alphabet + cursor;
		return answer;
	}

	/* A�? 만들�? ?��?�� ?��?�� */
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
	
	/* 커서 ?��?�� ?��?�� */
	public static int cursor_move(String name, int not_A) {
		int cursor = name.length();
		/* ?��?��?��?���? ?��?�� name?�� 0번인?��?���? ?��?��?���? 주어�? ?�� ?��?�� z�? �??�� */
		name = '*' + name.substring(1);
		/* q1 �??�� 짧�? 길이�? 구하?�� deque, q2?�� ?��?�� ?�� q1?�� 복원?���? ?��?�� deque, q3?? ?��?��,?��미길?���? 반환?���? ?��?�� deque-z?�� ?���? */
		Deque<Character> q1 = new LinkedList<Character>();
		Deque<Character> q2 = new LinkedList<Character>();
		Deque<Character> q3 = new LinkedList<Character>();
		
		/* deque 초기?�� */
		for (int i = 0; i < name.length(); i++) {
			q1.addLast(name.charAt(i));
			q2.addLast(name.charAt(i));
		}
		
		System.out.println("초기?��?��");
		System.out.println(q1);
		System.out.println();
		
		/* 커서?��?��?��?���? 계산 */
		for (int i = 0; i < not_A; i++) {
			/* q1?��?�� 최좌�? A�? ?��거하면서 q2?�� 추�? */
			while (q1.peekFirst() == 'A') {
				q2.removeFirst();
				q2.addLast(q1.removeFirst());
			}
			/* q1?��?�� 최우�? A�? ?���? */
			while (q1.peekLast() == 'A') {
				q1.removeLast();
			}
			/* ?�� ?��?���? q3?�� q1?�� 복사?���?, ?��?��, ?���? 길이�? 구함 */
			q3.addAll(q1);
			int prefix = -1;
			/* ?��?�� ?��?��?��기로 ?�� 'z'�? ?��?��?��?�� ?��?�� ?��미길?���? 구함 */
			while (q3.removeFirst() != '*') {
				prefix++;
			}
			
			int suffix = q3.size() - 1;
			/* 계산?�� 값과 최솟값을 비교?��?�� 최솟�? ???�� */
			cursor = Math.min(cursor, q1.size() + Math.min(prefix, suffix));
			
			/* ?��?��?�� 종료?�� deque ?���? */
			q2.addLast(q1.removeFirst());
			q2.removeFirst();
			q1.clear();
			q3.clear();
			q1.addAll(q2);

		}
		return cursor;
	}
}
