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
			int ret = solution(names[i]); // ?¬κΈ°λ κ°μ μ½λ? λ§κ² ?? ?λ©? ?©??€.
			if (ret != answers[i]) {
				System.out.println("names[i]: " + names[i]);
				System.out.println("answers[i]: " + answers[i]);
				System.out.println("ret: " + ret + "\n");
			}
		}
		*/
	}

	public static int solution(String name) {
		/* ?°?°? ?? intλ³?? ? ?Έ λ°? μ΄κΈ°?, alphabet?? ??λ²³λ???? cursor? ?΄??? not_A? Aκ°? ??κ°?? */
		int alphabet = 0;
		int cursor = name.length();
		int not_A = 1;

		/* ??λ²³λ????λ₯? κ΅¬νκ³?, Aκ°? ?? κ°??λ₯? κ΅¬ν¨ */
		for (int i = 0; i < name.length(); i++) {
			/* λ©μ???΄? κ°???± ?₯? */
			alphabet += change_A(name, i);
			if (name.charAt(i) != 'A') {
				not_A++;
			}
		}
		
		/* μ»€μ?΄???λ₯? κ΅¬ν? λ©μ?*/
		cursor = cursor_move(name, not_A);
		
		int answer = alphabet + cursor;
		return answer;
	}

	/* Aλ₯? λ§λ€κΈ? ?? ?? */
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
	
	/* μ»€μ ?΄? ?? */
	public static int cursor_move(String name, int not_A) {
		int cursor = name.length();
		/* ?°?°?Έ?λ₯? ??΄ name? 0λ²μΈ?±?€λ₯? ?? ₯?Όλ‘? μ£Όμ΄μ§? ? ?? zλ‘? λ³?? */
		name = '*' + name.substring(1);
		/* q1 κ°??₯ μ§§μ? κΈΈμ΄λ₯? κ΅¬ν? deque, q2? ?°?° ? q1? λ³΅μ?κΈ? ?? deque, q3?? ? ?,? λ―ΈκΈΈ?΄λ₯? λ°ν?κΈ? ?? deque-z? ?°κ²? */
		Deque<Character> q1 = new LinkedList<Character>();
		Deque<Character> q2 = new LinkedList<Character>();
		Deque<Character> q3 = new LinkedList<Character>();
		
		/* deque μ΄κΈ°? */
		for (int i = 0; i < name.length(); i++) {
			q1.addLast(name.charAt(i));
			q2.addLast(name.charAt(i));
		}
		
		System.out.println("μ΄κΈ°??");
		System.out.println(q1);
		System.out.println();
		
		/* μ»€μ?΄???λ₯? κ³μ° */
		for (int i = 0; i < not_A; i++) {
			/* q1?? μ΅μ’μΈ? Aλ₯? ? κ±°νλ©΄μ q2? μΆκ? */
			while (q1.peekFirst() == 'A') {
				q2.removeFirst();
				q2.addLast(q1.removeFirst());
			}
			/* q1?? μ΅μ°μΈ? Aλ₯? ? κ±? */
			while (q1.peekLast() == 'A') {
				q1.removeLast();
			}
			/* ?΄ ??λ‘? q3? q1? λ³΅μ¬?κ³?, ? ?, ? λ―? κΈΈμ΄λ₯? κ΅¬ν¨ */
			q3.addAll(q1);
			int prefix = -1;
			/* ?? ?΄?©?κΈ°λ‘ ? 'z'λ₯? ?΄?©?΄? ? ? ? λ―ΈκΈΈ?΄λ₯? κ΅¬ν¨ */
			while (q3.removeFirst() != '*') {
				prefix++;
			}
			
			int suffix = q3.size() - 1;
			/* κ³μ°? κ°κ³Ό μ΅μκ°μ λΉκ΅?΄? μ΅μκ°? ???₯ */
			cursor = Math.min(cursor, q1.size() + Math.min(prefix, suffix));
			
			/* ?°?°?΄ μ’λ£? deque ? λ¦? */
			q2.addLast(q1.removeFirst());
			q2.removeFirst();
			q1.clear();
			q3.clear();
			q1.addAll(q2);

		}
		return cursor;
	}
}
