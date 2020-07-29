package programmers;

import java.util.Stack;

public class programmers_17679 {

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		//String[] board = { "AA", "AA","AA" };
		//String[] board = { "ABCDE", "ABCDE", "ABCDE", "ABCDE" };
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF","TMMTTJ"};
		System.out.println(solution(m, n, board));

	}

	// A,C,F,J,M,N,T,R
	public static int solution(int m, int n, String[] board) {
		/* 배열 초기화 */
		char[][] table = new char[m][n];
		for (int i = 0; i < m; i++) {
			table[i] = board[i].toCharArray();
		}

		/* 상태를 저장할 temp 배열 복사 */
		char[][] table_copy = copy_table(table);
		
		/* 깨트릴 블록을 table에서 찾아서 table_copy에 복사 */
		find_block(table, table_copy);
		
		while (change_anymore(table, table_copy)) {
			/* X를 최상단으로 뺌 */
			sort(table_copy);
			/* 배열을 다시 복사 */
			table = copy_table(table_copy);
			/* 깨트릴 블록을 table에서 찾아서 table_copy에 복사 */
			find_block(table, table_copy);
		}
		
		/* 최종확인을 위한 print */
		//print(table_copy);
		int answer = count(table_copy);
		return answer;
	}

	/* 사각형 찾아서 x표시 */
	public static void find_block(char[][] table, char[][] table_copy) {
		for (int i = 0; i < table.length - 1; i++) {
			for (int j = 0; j < table[i].length - 1; j++) {
				if (table[i][j] == table[i][j + 1] && table[i][j] == table[i + 1][j]
						&& table[i][j] == table[i + 1][j + 1]) {
					table_copy[i][j] = table_copy[i + 1][j] = table_copy[i][j + 1] = table_copy[i + 1][j + 1] = '*';
				}
			}
		}
	}

	/* 중간 체크를 위한 print */
	public static void print(char[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}

	/* 더 이상 터트릴 블록이 없는지 확인 */
	public static boolean change_anymore(char[][] table, char[][] table_copy) {
		boolean answer = false;
		for (int i = 0; i < table.length - 1; i++) {
			for (int j = 0; j < table[i].length - 1; j++) {
				if (table[i][j] != table_copy[i][j]) {
					return true;
				}
			}
		}
		return answer;
	}

	/* 배열 복사 */
	public static char[][] copy_table(char[][] table) {
		char[][] table_copy = table.clone();
		for (int i = 0; i < table.length; i++) {
			table_copy[i] = table[i].clone();
		}
		return table_copy;
	}

	/* X를 카운트 - 정답찾기 */
	public static int count(char[][] table) {
		int answer = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] == '*') {
					answer++;
				}
			}
		}
		return answer;
	}

	/* X를 위로 밀기 */
	public static void sort(char[][] table) {
		Stack<Character> stack = new Stack<Character>();
		for (int j = 0; j < table[0].length; j++) {
			for (int i = 0; i < table.length; i++) {
				if (table[i][j] != '*') {
					stack.add(table[i][j]);
				}
			}
			for (int k = table.length - 1; k >= 0; k--) {
				if (!stack.isEmpty()) {
					table[k][j] = stack.pop();
				} else {
					table[k][j] = '*';
				}

			}
		}
	}
}
