package programmers;

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
			int ret = solution(names[i]); // 여기는 각자 코드에 맞게 수정하면 됩니다.
			if (ret != answers[i]) {
				System.out.println("names[i]: " + names[i]);
				System.out.println("answers[i]: " + answers[i]);
				System.out.println("ret: " + ret + "\n");
			}
		}
		*/
	}

	public static int solution(String name) {
		/* 연산을 위한 int변수 선언 및 초기화, alphabet은 알파벳변환횟수 cursor는 이동횟수 not_A는 A가 아닌갯수 */
		int alphabet = 0;
		int cursor = name.length();
		int not_A = 1;

		/* 알파벳변환횟수를 구하고, A가 아닌 갯수를 구함 */
		for (int i = 0; i < name.length(); i++) {
			/* 메소드화해서 가독성 향상 */
			alphabet += change_A(name, i);
			if (name.charAt(i) != 'A') {
				not_A++;
			}
		}
		
		/* 커서이동횟수를 구하는 메소드*/
		cursor = cursor_move(name, not_A);
		
		int answer = alphabet + cursor;
		return answer;
	}

	/* A를 만들기 위한 횟수 */
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
	
	/* 커서 이동 횟수 */
	public static int cursor_move(String name, int not_A) {
		int cursor = name.length();
		/* 연산편의를 위해 name의 0번인덱스를 입력으로 주어질 수 없는 z로 변환 */
		name = '*' + name.substring(1);
		/* q1 가장 짧은 길이를 구하는 deque, q2는 연산 후 q1을 복원하기 위한 deque, q3은 접두,접미길이를 반환하기 위한 deque-z랑 연결 */
		Deque<Character> q1 = new LinkedList<Character>();
		Deque<Character> q2 = new LinkedList<Character>();
		Deque<Character> q3 = new LinkedList<Character>();
		
		/* deque 초기화 */
		for (int i = 0; i < name.length(); i++) {
			q1.addLast(name.charAt(i));
			q2.addLast(name.charAt(i));
		}
		
		System.out.println("초기상태");
		System.out.println(q1);
		System.out.println();
		
		/* 커서이동횟수를 계산 */
		for (int i = 0; i < not_A; i++) {
			/* q1에서 최좌측 A를 제거하면서 q2에 추가 */
			while (q1.peekFirst() == 'A') {
				q2.removeFirst();
				q2.addLast(q1.removeFirst());
			}
			/* q1에서 최우측 A를 제거 */
			while (q1.peekLast() == 'A') {
				q1.removeLast();
			}
			/* 이 상태로 q3에 q1을 복사하고, 접두, 접미 길이를 구함 */
			q3.addAll(q1);
			int prefix = -1;
			/* 앞서 이용하기로 한 'z'를 이용해서 접두 접미길이를 구함 */
			while (q3.removeFirst() != '*') {
				prefix++;
			}
			
			int suffix = q3.size() - 1;
			/* 계산한 값과 최솟값을 비교해서 최솟값 저장 */
			cursor = Math.min(cursor, q1.size() + Math.min(prefix, suffix));
			
			/* 연산이 종료된 deque 정리 */
			q2.addLast(q1.removeFirst());
			q2.removeFirst();
			q1.clear();
			q3.clear();
			q1.addAll(q2);

		}
		return cursor;
	}
}
